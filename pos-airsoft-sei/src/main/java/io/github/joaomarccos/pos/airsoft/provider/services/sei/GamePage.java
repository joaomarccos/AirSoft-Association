package io.github.joaomarccos.pos.airsoft.provider.services.sei;

import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfGamesTO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GamePage {

    /**
     * Retorna 5 ou menos jogos realizados de acordo com o numero da página
     * indicada. Caso o numero da página não seja válida, uma lista vazia é
     * retornada.
     *
     * @param page
     * @return Lista de Game
     */
    @WebMethod
    ListOfGamesTO getFinishedGames(int page);

    /**
     * Retorna os jogos que ainda não foram realizados nem cancelados
     * @return 
     */
    @WebMethod
    ListOfGamesTO getGames();
}
