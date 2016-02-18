package io.github.joaomarccos.pos.airsoft.provider.services.sei;

import io.github.joaomarccos.pos.airsoft.entitys.Player;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PlayerManager {

    /**
     * Registra um novo Jogadar a base de Jogadores
     *
     * @param name
     * @param email
     * @param phone
     * @return Player
     */
    @WebMethod
    Player registerNewPlayer(String name, String email, String phone);

}
