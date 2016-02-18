package io.github.joaomarccos.pos.airsoft.dao;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import java.util.List;

/**
 * Dao de Game
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface GameDAO extends DAO<Game> {

    /**
     * Retorna o número de jogos salvos
     *
     * @return
     */
    public long numberOfGames();

    public List<Game> findPerPage(int page);
}
