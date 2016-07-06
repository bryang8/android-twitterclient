package projects.bryang8.com.twitterclient.images.ui;


import java.util.List;

import projects.bryang8.com.twitterclient.images.entities.Image;

/**
 * Created by bryan_g8
 */

public interface ImagesView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onImagesError(String error);
    void setImages(List<Image> items);
}
