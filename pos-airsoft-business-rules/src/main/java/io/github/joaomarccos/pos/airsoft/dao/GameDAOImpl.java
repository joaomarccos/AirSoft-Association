package io.github.joaomarccos.pos.airsoft.dao;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class GameDAOImpl extends DAOJPA<Game> implements GameDAO {

    /**
     * Quantidade máxima retornada em em uma consulta paginada
     */
    private static final int PAGESIZE = 5;

    GameDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public long numberOfGames() {
        Query query = entityManager.createNamedQuery("games.finished.lenght");
        return (long) query.getSingleResult();

    }

    @Override
    public List<Game> findPerPage(int page) {

        long numberOfGamesFinished = numberOfGames();
        long numberOfPages = numberOfGamesFinished / PAGESIZE;
        numberOfPages += numberOfGamesFinished % PAGESIZE > 0 ? 1 : 0;
        if (page <= numberOfPages) {
            Query query = entityManager.createNamedQuery("games.finished");
            query.setFirstResult(--page * PAGESIZE);
            query.setMaxResults(PAGESIZE);

            return query.getResultList();
        }

        return null;

    }

}
