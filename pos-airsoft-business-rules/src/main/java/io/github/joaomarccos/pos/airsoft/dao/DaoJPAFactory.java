package io.github.joaomarccos.pos.airsoft.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class DaoJPAFactory {

    private static final String PU = "PU-Airsoft";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PU).createEntityManager();

    public static DAO createDefaultDao() {
        return new DAOJPA(em);
    }

    public static GameDAO createGameDao() {
        return new GameDAOImpl(em);
    }
}
