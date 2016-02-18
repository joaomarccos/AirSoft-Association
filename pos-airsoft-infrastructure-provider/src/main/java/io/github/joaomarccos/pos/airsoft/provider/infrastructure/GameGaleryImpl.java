package io.github.joaomarccos.pos.airsoft.provider.infrastructure;

import io.github.joaomarccos.pos.airsoft.entitys.Album;
import io.github.joaomarccos.pos.airsoft.entitys.Game;
import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameGalery;
import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfImagesTO;
import io.github.joaomarccos.pos.airsoft.repositories.AlbumRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.GameRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.AlbumRepository;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameRepository;
import javax.jws.WebService;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(endpointInterface = "io.github.joaomarccos.pos.airsoft.provider.services.sei.GameGalery")
public class GameGaleryImpl implements GameGalery {

    private final AlbumRepository albumrepo;
    private final GameRepository gamerepo;

    public GameGaleryImpl() {
        this.albumrepo = new AlbumRepositoryImpl();
        this.gamerepo = new GameRepositoryImpl();
    }

    @Override
    public Album createNewAlbum(long gameId, String name, ListOfImagesTO images) {
        Album album = new Album(name, images.getPictures(), gameId);
        Game game = gamerepo.findById(gameId);
        game.getAlbum().setGameId(gameId);
        game.getAlbum().setImages(images.getPictures());
        game.getAlbum().setName(name);
        gamerepo.update(game);
        return album;
    }

    @Override
    public Album getAlbum(long albumId) {
        return albumrepo.find(albumId);
    }

}
