package io.github.joaomarccos.pos.airsoft.repositories.interfaces;

import io.github.joaomarccos.pos.airsoft.entitys.Album;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface AlbumRepository extends Repository<Album> {
    Album find(long id);
}
