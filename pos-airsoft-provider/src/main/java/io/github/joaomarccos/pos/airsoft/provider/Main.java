package io.github.joaomarccos.pos.airsoft.provider;

import io.github.joaomarccos.pos.airsoft.provider.services.domain.sib.GameConfirmImpl;
import io.github.joaomarccos.pos.airsoft.provider.services.domain.sib.GameManagerImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class Main {

    /**
     * Publicação dos serviços.
     *
     * @param args
     */
    public static void main(String[] args) {

        Endpoint.publish("http://127.0.0.1:9876/gameManager", new GameManagerImpl());        
        Endpoint.publish("http://127.0.0.1:9876/gameConfirm", new GameConfirmImpl());

    }
}
