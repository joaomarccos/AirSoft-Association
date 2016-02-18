package io.github.joaomarccos.pos.airsoft.repositories;

import io.github.joaomarccos.pos.airsoft.dao.DAO;
import io.github.joaomarccos.pos.airsoft.dao.DaoJPAFactory;
import io.github.joaomarccos.pos.airsoft.entitys.GameInvitation;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameInvitationRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class GameInvitationRepositoryImpl implements GameInvitationRepository {

    private final DAO<GameInvitation> dao;

    public GameInvitationRepositoryImpl() {
        this.dao = DaoJPAFactory.createDefaultDao();
    }

    @Override
    public void save(GameInvitation entity) {
        dao.save(entity);
    }

    @Override
    public void delete(GameInvitation entity) {
        dao.delete(entity);
    }

    @Override
    public void update(GameInvitation entity) {
        dao.update(entity);
    }

    @Override
    public GameInvitation findByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return dao.simpleQuery("invitation.findbytoken", params);
    }

}
