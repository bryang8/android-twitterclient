package projects.bryang8.com.twitterclient.images;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import projects.bryang8.com.twitterclient.images.ui.ImagesView;
import projects.bryang8.com.twitterclient.images.entities.Image;
import projects.bryang8.com.twitterclient.images.events.ImagesEvent;
import projects.bryang8.com.twitterclient.lib.EventBus;
/**
 * Created by bryan_g8
 */

public class ImagesPresenterImpl implements ImagesPresenter {
    private EventBus eventBus;
    private ImagesView imagesView;
    private final ImagesInteractor imagesInteractor;

    public ImagesPresenterImpl(ImagesView imagesView, ImagesInteractor imagesInteractor, EventBus eventBus) {
        this.eventBus = eventBus;
        this.imagesView = imagesView;
        this.imagesInteractor = imagesInteractor;
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.imagesView = null;
    }

    @Override
    public void getImageTweets(){
        if (this.imagesView != null){
            imagesView.hideList();
            imagesView.showProgress();
        }

        this.imagesInteractor.getImageItemsList();
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String errorMsg = event.getError();
        if (this.imagesView != null) {
            imagesView.showList();
            imagesView.hideProgress();
            if (errorMsg != null) {
                this.imagesView.onImagesError(errorMsg);
            } else {
                List<Image> items = event.getImages();
                if (items != null && !items.isEmpty()) {
                    this.imagesView.setImages(items);
                }
            }
        }
    }
}
