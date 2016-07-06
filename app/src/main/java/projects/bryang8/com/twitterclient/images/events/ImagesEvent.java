package projects.bryang8.com.twitterclient.images.events;

import java.util.List;

import projects.bryang8.com.twitterclient.images.entities.Image;

/**
 * Created by bryan_g8
 */

public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
