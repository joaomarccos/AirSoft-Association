package io.github.joaomarccos.pos.airsoft.provider.infrastructure;

import io.github.joaomarccos.pos.airsoft.entitys.Player;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.PlayerManager;
import io.github.joaomarccos.pos.airsoft.repositories.PlayerRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.PlayerRepository;
import javax.jws.WebService;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(endpointInterface = "io.github.joaomarccos.pos.airsoft.provider.services.sei.PlayerManager")
public class PlayerManagerImpl implements PlayerManager {

    private final PlayerRepository playerepo;

    public PlayerManagerImpl() {
        this.playerepo = new PlayerRepositoryImpl();
    }

    @Override
    public Player registerNewPlayer(String name, String email, String phone) {
        Player player = new Player(name, email, phone);
        playerepo.save(player);
        return player;
    }    

}
