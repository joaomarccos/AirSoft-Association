package io.github.joaomarccos.pos.airsoft.provider.services.domain.sib;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import io.github.joaomarccos.pos.airsoft.enums.GameStatus;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameManager;
import io.github.joaomarccos.pos.airsoft.repositories.GameRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.PlayerRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameRepository;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.PlayerRepository;
import io.github.joaomarccos.pos.airsoft.services.InvitationPlayerService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 * Serviço responsável por gerenciar um jogo de Airsoft - Criar um novo jogo -
 * Encerrar um jogo - Cancelar um jogo
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(endpointInterface = "io.github.joaomarccos.pos.airsoft.provider.services.sei.GameManager")
public class GameManagerImpl implements GameManager {

    private final GameRepository gamerepo;
    private final PlayerRepository playerrepo;

    public GameManagerImpl() {
        this.gamerepo = new GameRepositoryImpl();
        this.playerrepo = new PlayerRepositoryImpl();
    }

    @Override
    public void cancelGame(long gameId) {
        Game game = gamerepo.findById(gameId);
        if (game != null) {
            game.setStatus(GameStatus.CANCELED.name());
            gamerepo.update(game);
        }
    }

    @Override
    public void finishGame(long gameId) {
        Game game = gamerepo.findById(gameId);
        if (game != null) {
            game.setStatus(GameStatus.FINISHED.name());
            gamerepo.update(game);
        }
    }

    @Override
    public Game createNewGame(String goal, String plot, String mission, String site, String timetable, byte[] thematicImage) {
        try {
            Game game = new Game(goal, plot, mission, site, timetable, thematicImage);
            gamerepo.save(game);

            Runnable run = () -> {
                InvitationPlayerService ips = new InvitationPlayerService();
                ips.notifyPlayers(game);
            };

            new Thread(run).start();

            return game;
        } catch (Exception e) {
            Logger.getLogger(GameManagerImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
