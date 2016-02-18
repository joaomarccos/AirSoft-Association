package io.github.joaomarccos.pos.airsoft.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@NamedQueries({
    @NamedQuery(name = "invitation.findbytoken", query = "SELECT c FROM GameInvitation c WHERE c.token = :token")
})
@Entity
public class GameInvitation implements Serializable {

    private long gameId;
    private long playerId;
    @Id
    private String token;

    public GameInvitation(long gameId, long playerId, String token) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.token = token;
    }

    public GameInvitation() {
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
