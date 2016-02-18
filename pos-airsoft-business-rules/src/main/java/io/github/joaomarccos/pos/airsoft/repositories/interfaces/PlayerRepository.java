package io.github.joaomarccos.pos.airsoft.repositories.interfaces;

import io.github.joaomarccos.pos.airsoft.entitys.Player;
import java.util.List;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface PlayerRepository extends Repository<Player> {

    Player findbyId(long id);
    List<Player> findAll(); 
}
