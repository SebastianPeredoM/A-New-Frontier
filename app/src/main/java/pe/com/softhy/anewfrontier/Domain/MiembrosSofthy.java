package pe.com.softhy.anewfrontier.Domain;

import android.widget.ImageView;

/**
 * Created by Sebastian on 24/06/2017.
 */

public class MiembrosSofthy {
    private String name;
    private int image;
    public MiembrosSofthy(String name) {
        this.setName(name);
//        this.setImage(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
