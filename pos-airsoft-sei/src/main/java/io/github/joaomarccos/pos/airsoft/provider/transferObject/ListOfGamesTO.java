package io.github.joaomarccos.pos.airsoft.provider.transferObject;

import io.github.joaomarccos.pos.airsoft.entitys.Game;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@XmlRootElement(name = "gamePage")
public class ListOfGamesTO {

    @XmlElement(name = "gameList")
    private List<Game> gameList;

    public ListOfGamesTO(List<Game> games) {
        this.gameList = games;
    }

    public ListOfGamesTO() {
    }

    public List<Game> getGames() {
        return gameList;
    }

    public void setGames(List<Game> games) {
        this.gameList = games;
    }

}
