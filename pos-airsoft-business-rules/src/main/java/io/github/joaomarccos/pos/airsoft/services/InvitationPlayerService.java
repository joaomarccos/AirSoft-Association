package io.github.joaomarccos.pos.airsoft.services;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import io.github.joaomarccos.pos.airsoft.entitys.GameInvitation;
import io.github.joaomarccos.pos.airsoft.entitys.Player;
import io.github.joaomarccos.pos.airsoft.enums.GameStatus;
import io.github.joaomarccos.pos.airsoft.repositories.GameInvitationRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.GameRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.PlayerRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameInvitationRepository;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameRepository;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.PlayerRepository;
import io.github.joaomarccos.pos.airsoft.util.email.EmailSender;
import io.github.joaomarccos.pos.airsoft.util.token.TokenGenerator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class InvitationPlayerService {

    private final GameInvitationRepository pgrepo;
    private final GameRepository gamerepo;
    private final PlayerRepository playerrepo;

    public InvitationPlayerService() {
        this.pgrepo = new GameInvitationRepositoryImpl();
        this.gamerepo = new GameRepositoryImpl();
        this.playerrepo = new PlayerRepositoryImpl();
    }

    /**
     * Gera um token unico relacionado à uma solicitação de participação em um
     * jogo
     *
     * @param gameId
     * @param playerId
     * @return token
     */
    private String registerInvitation(long gameId, long playerId) {
        String token = TokenGenerator.generateToken(String.valueOf(gameId + playerId));
        GameInvitation pgc = new GameInvitation(gameId, playerId, token);
        pgrepo.save(pgc);
        return token;
    }

    /**
     * Notifica todos os jogadores sobre um novo jogo, por email. Este email
     * contém um link de confirmação de participação que quando acesso,
     * adicionará automaticamente o jogador ao jogo
     *
     * @param game
     */
    public void notifyPlayers(Game game) {
        List<Player> players = playerrepo.findAll();
        EmailSender es = new EmailSender();

        players.stream().forEach((player) -> {

            String token = registerInvitation(game.getId(), player.getId());

            String msgBody = game.toString() + "\n\nPara confirmar sua participação clink no link abaixo:\n\n"
                    + "http://localhost:8080/game/confirm/" + token;

            try {
                es.sendEmail(player.getEmail(), msgBody, "Um novo Jogo de AirSoft está prestes a começar");
            } catch (EmailException ex) {
                Logger.getLogger(InvitationPlayerService.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }

    public void deleteInvitation(String token) {
        GameInvitation confirmation = pgrepo.findByToken(token);
        if (confirmation != null) {
            pgrepo.delete(confirmation);
        }
    }

    /**
     * Confirma a participação de um Jogador em um Jogo. Para isso é feita uma
     * busca de uma notificação de um novo jogo a partir de um token único na
     * base de dados, caso exista e o jogo ainda não esteja cancelado ou
     * encerrado, o jogador é registrado no jogo
     *
     * @param token
     * @return true caso a confirmação ocorra
     */
    public boolean confirmInvitation(String token) {
        try {
            GameInvitation invitation = pgrepo.findByToken(token);
            if (invitation != null) {
                Game game = gamerepo.findById(invitation.getGameId());
                Player player = playerrepo.findbyId(invitation.getPlayerId());
                deleteInvitation(token);

                if (game.getStatus().equals(GameStatus.DEFAULT.name())) {
                    game.getPlayers().add(player);
                    gamerepo.update(game);
                    return true;
                }
            }
            
            return false;
            
        } catch (Exception e) {
            return false;
        }

    }
}
