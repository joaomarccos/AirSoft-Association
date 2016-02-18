package io.github.joaomarccos.pos.airsoft.repositories;

import io.github.joaomarccos.pos.airsoft.dao.DAO;
import io.github.joaomarccos.pos.airsoft.dao.DaoJPAFactory;
import io.github.joaomarccos.pos.airsoft.entitys.Album;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.AlbumRepository;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class AlbumRepositoryImpl implements AlbumRepository {

    private DAO<Album> dao;

    public AlbumRepositoryImpl() {
        this.dao = DaoJPAFactory.createDefaultDao();
    }

    @Override
    public void save(Album entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Album entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Album entity) {
        dao.update(entity);
    }

    @Override
    public Album find(long id) {
        return dao.find(id, Album.class);
    }

}
