package io.github.joaomarccos.pos.airsoft.web.facade;

import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameManager;
import io.github.joaomarccos.pos.airsoft.consumers.util.ServiceGetter;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameConfirm;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameGalery;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.GamePage;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.PlayerManager;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.xml.ws.Service;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Named
public class ServiceFacade {

    public ServiceFacade() {
    }

    public GameManager getGameManagerService() {
        try {
            Service service = ServiceGetter.getService("http://localhost:9876/gameManager?wsdl",
                    "http://sib.domain.services.provider.airsoft.pos.joaomarccos.github.io/",
                    "GameManagerImplService");
            return service.getPort(GameManager.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PlayerManager getPlayerManagerService() {
        try {
            Service service = ServiceGetter.getService("http://127.0.0.1:9877/PlayerManager?wsdl",
                    "http://infrastructure.provider.airsoft.pos.joaomarccos.github.io/",
                    "PlayerManagerImplService");
            return service.getPort(PlayerManager.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GameConfirm getGameConfirmService() {
        try {
            Service service = ServiceGetter.getService("http://127.0.0.1:9876/gameConfirm?wsdl",
                    "http://sib.domain.services.provider.airsoft.pos.joaomarccos.github.io/",
                    "GameConfirmImplService");
            return service.getPort(GameConfirm.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GamePage getGamePageService() {
        try {
            Service service = ServiceGetter.getService("http://127.0.0.1:9877/gamePage?wsdl",
                    "http://infrastructure.provider.airsoft.pos.joaomarccos.github.io/",
                    "GamePageImplService");
            return service.getPort(GamePage.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GameGalery getGameGaleryService() {
        try {
            Service service = ServiceGetter.getService("http://127.0.0.1:9877/gameGalery?wsdl",
                    "http://infrastructure.provider.airsoft.pos.joaomarccos.github.io/",
                    "GameGaleryImplService");
            return service.getPort(GameGalery.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
