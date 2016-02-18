package io.github.joaomarccos.pos.airsoft.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Entity
public class Image implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private byte[] bytes;

    public Image(byte[] bytes) {
        this.bytes = bytes;
    }

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

}
