package io.github.joaomarccos.pos.airsoft.repositories;

import io.github.joaomarccos.pos.airsoft.dao.DAO;
import io.github.joaomarccos.pos.airsoft.dao.DaoJPAFactory;
import io.github.joaomarccos.pos.airsoft.entitys.Player;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.PlayerRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class PlayerRepositoryImpl implements PlayerRepository {

    private final DAO<Player> dao;

    public PlayerRepositoryImpl() {
        this.dao = DaoJPAFactory.createDefaultDao();
    }

    @Override
    public void save(Player entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Player entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Player entity) {
        dao.update(entity);
    }

    @Override
    public Player findbyId(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return dao.simpleQuery("players.findbyid", params);
    }

    @Override
    public List<Player> findAll() {
        return dao.listQuery("players.all", null);
    }

}
