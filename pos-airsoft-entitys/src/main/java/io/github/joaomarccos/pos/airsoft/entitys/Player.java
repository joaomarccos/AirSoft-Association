package io.github.joaomarccos.pos.airsoft.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 * Representa um membro de um jogo de Airsoft
 */
@NamedQueries({
    @NamedQuery(name = "players.findbyid", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "players.all", query = "SELECT p FROM Player p")
})
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;

    public Player() {
    }

    public Player(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
