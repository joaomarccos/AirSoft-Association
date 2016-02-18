package io.github.joaomarccos.pos.airsoft.provider.transferObject;

import io.github.joaomarccos.pos.airsoft.entitys.Image;
import java.io.Serializable;
import java.util.List;

/** 
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class ListOfImagesTO implements Serializable {

    private List<Image> images;

    public ListOfImagesTO() {
    }

    public ListOfImagesTO(List<Image> pictures) {
        this.images = pictures;
    }

    public List<Image> getPictures() {
        return images;
    }

    public void setPictures(List<Image> pictures) {
        this.images = pictures;
    }

}
