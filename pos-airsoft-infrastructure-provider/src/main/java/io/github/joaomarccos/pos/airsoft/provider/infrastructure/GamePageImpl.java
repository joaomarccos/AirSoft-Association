package io.github.joaomarccos.pos.airsoft.provider.infrastructure;

import io.github.joaomarccos.pos.airsoft.provider.services.sei.GamePage;
import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfGamesTO;
import io.github.joaomarccos.pos.airsoft.repositories.GameRepositoryImpl;
import io.github.joaomarccos.pos.airsoft.repositories.interfaces.GameRepository;
import javax.jws.WebService;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(endpointInterface = "io.github.joaomarccos.pos.airsoft.provider.services.sei.GamePage")
public class GamePageImpl implements GamePage {

    private final GameRepository gamerepo;

    public GamePageImpl() {
        this.gamerepo = new GameRepositoryImpl();
    }

    @Override
    public ListOfGamesTO getFinishedGames(int page) {
        return new ListOfGamesTO(gamerepo.findPerPage(page));
    }

    @Override
    public ListOfGamesTO getGames() {
        return new ListOfGamesTO(gamerepo.findAll());
    }

}
