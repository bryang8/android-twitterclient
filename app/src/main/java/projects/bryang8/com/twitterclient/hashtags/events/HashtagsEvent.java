package projects.bryang8.com.twitterclient.hashtags.events;

import java.util.List;

import projects.bryang8.com.twitterclient.hashtags.entities.Hashtag;

/**
 * Created by bryan_g8
 */

public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
