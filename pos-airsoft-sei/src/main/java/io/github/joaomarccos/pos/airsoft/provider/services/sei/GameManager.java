package io.github.joaomarccos.pos.airsoft.provider.services.sei;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import java.time.LocalDateTime;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GameManager {

    /**
     * Cria um novo jogo e notifica todos os jogadores da base de jogadores 
     * sobre o mesmo, caso confirmem sua participação são adicionados ao jogo
     * @param goal
     * @param plot
     * @param mission
     * @param site
     * @param timetable
     * @param thematicImage
     * @return Game
     */
    @WebMethod Game createNewGame(String goal, String plot, String mission, String site, String timetable, byte[] thematicImage);

    /**
     * Cancela um jogo. Muda seu status para CANCELED
     * @param gameId 
     */
    @WebMethod void cancelGame(long gameId);

    /**
     * Termina um jogo. Muda seu status para FINISHED
     * @param gameId 
     */
    @WebMethod void finishGame(long gameId);
}
