package io.github.joaomarccos.pos.airsoft.repositories.interfaces;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import java.util.List;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface GameRepository extends Repository<Game> {

    public List<Game> findAll();
    public List<Game> findPerPage(int page);
    public Game findById(long id);
    public long numberOfGames();
    
            
}
