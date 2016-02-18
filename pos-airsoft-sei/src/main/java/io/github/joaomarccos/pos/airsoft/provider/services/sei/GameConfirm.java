package io.github.joaomarccos.pos.airsoft.provider.services.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GameConfirm {

    /**
     * Confirma a participação de um Jogador em um Jogo.
     * @param token único que identifica um convite para um jogo
     * @return 
     */
    @WebMethod boolean confirmParticipation(String token);
}
