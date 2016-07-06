package projects.bryang8.com.twitterclient.images;

import projects.bryang8.com.twitterclient.images.events.ImagesEvent;

/**
 * Created by bryan_g8
 */

public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
