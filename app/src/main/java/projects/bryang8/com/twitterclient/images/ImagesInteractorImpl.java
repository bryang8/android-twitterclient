package projects.bryang8.com.twitterclient.images;

import javax.inject.Inject;


/**
 * Created by bryan_g8
 */

public class ImagesInteractorImpl implements ImagesInteractor {
    private final ImagesRepository imagesRepository;

    @Inject
    public ImagesInteractorImpl(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Override
    public void getImageItemsList() {
        this.imagesRepository.getImages();

    }
}
