package io.github.joaomarccos.pos.airsoft.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 * Representa um jogo de Airsoft
 */
@NamedQueries({
    @NamedQuery(name = "games.all", query = "SELECT g FROM Game g WHERE g.status = 'DEFAULT'"),
    @NamedQuery(name = "games.finished", query = "SELECT g FROM Game g WHERE g.status = 'FINISHED' ORDER BY g.id ASC"),
    @NamedQuery(name = "games.findbyid", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "games.finished.lenght", query = "SELECT COUNT(g) FROM Game g WHERE g.status = 'FINISHED'")
})
@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String goal;
    private String plot;
    private String mission;
    private String site;
    private String status;
    private String timetable;
    private byte[] thematicImage;

    @OneToMany
    private List<Player> players;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Album album;

    public Game() {
        this.players = new ArrayList<>();
        this.album = new Album();
    }

    public Game(String goal, String plot, String mission, String site, String timetable, byte[] thematicImage) {
        this();
        this.goal = goal;
        this.plot = plot;
        this.mission = mission;
        this.site = site;
        this.timetable = timetable;
        this.thematicImage = thematicImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public byte[] getThematicImage() {
        return thematicImage;
    }

    public void setThematicImage(byte[] thematicImage) {
        this.thematicImage = thematicImage;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Objetivo:" + goal + "\n Enredo: " + plot + "\n Missão: " + mission + "\n Localzação: " + site + "\n Horário: " + timetable;
    }

}
