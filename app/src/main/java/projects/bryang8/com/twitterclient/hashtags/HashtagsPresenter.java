package projects.bryang8.com.twitterclient.hashtags;

import projects.bryang8.com.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by bryan_g8
 */

public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
