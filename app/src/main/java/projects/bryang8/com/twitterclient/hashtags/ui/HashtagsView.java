package projects.bryang8.com.twitterclient.hashtags.ui;

import java.util.List;

import projects.bryang8.com.twitterclient.hashtags.entities.Hashtag;

/**
 * Created by bryan_g8
 */

public interface HashtagsView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
