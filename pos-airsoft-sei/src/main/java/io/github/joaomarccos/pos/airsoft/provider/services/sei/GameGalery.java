package io.github.joaomarccos.pos.airsoft.provider.services.sei;

import io.github.joaomarccos.pos.airsoft.entitys.Album;
import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfImagesTO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GameGalery {

    /**
     * Cria um álbum de imagens para um jogo finalizado.
     *
     * @param gameId
     * @param name
     * @param images
     * @return
     */
    @WebMethod Album createNewAlbum(long gameId, String name, ListOfImagesTO images);

    /**
     * Retorna um álbum de imagens de um jogo
     *
     * @param albumId
     * @return
     */
    @WebMethod Album getAlbum(long albumId);
}
