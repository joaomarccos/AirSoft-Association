package io.github.joaomarccos.pos.airsoft.repositories;

import io.github.joaomarccos.pos.airsoft.dao.DaoJPAFactory;
import io.github.joaomarccos.pos.airsoft.dao.GameDAO;
import io.github.joaomarccos.pos.airsoft.enums.GameStatus;
import io.github.joaomarccos.pos.airsoft.entitys.Game;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class GameRepositoryImpl implements GameRepository {

    private final GameDAO dao;

    public GameRepositoryImpl() {
        this.dao = DaoJPAFactory.createGameDao();
    }

    @Override
    public void save(Game entity) {
        entity.setStatus(GameStatus.DEFAULT.name());
        dao.save(entity);
    }

    @Override
    public void delete(Game entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Game entity) {
        dao.update(entity);
    }

    @Override
    public List<Game> findAll() {
        List<Game> listQuery = dao.listQuery("games.all", null);
        return listQuery;
    }

    @Override
    public Game findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return dao.simpleQuery("games.findbyid", params);
    }

    @Override
    public long numberOfGames() {
        return dao.numberOfGames();
    }

    @Override
    public List<Game> findPerPage(int page) {
        return dao.findPerPage(page);
    }

}
