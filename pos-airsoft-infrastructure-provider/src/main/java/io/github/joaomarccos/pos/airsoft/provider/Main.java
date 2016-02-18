package io.github.joaomarccos.pos.airsoft.provider;

import io.github.joaomarccos.pos.airsoft.provider.infrastructure.GameGaleryImpl;
import io.github.joaomarccos.pos.airsoft.provider.infrastructure.GamePageImpl;
import io.github.joaomarccos.pos.airsoft.provider.infrastructure.PlayerManagerImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9877/PlayerManager", new PlayerManagerImpl());
        Endpoint.publish("http://127.0.0.1:9877/gameGalery", new GameGaleryImpl());
        Endpoint.publish("http://127.0.0.1:9877/gamePage", new GamePageImpl());

    }
}
