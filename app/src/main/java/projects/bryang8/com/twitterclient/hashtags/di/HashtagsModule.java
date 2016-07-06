package projects.bryang8.com.twitterclient.hashtags.di;


import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import projects.bryang8.com.twitterclient.api.CustomTwitterApiClient;
import projects.bryang8.com.twitterclient.hashtags.HashtagsInteractor;
import projects.bryang8.com.twitterclient.hashtags.HashtagsInteractorImpl;
import projects.bryang8.com.twitterclient.hashtags.HashtagsPresenter;
import projects.bryang8.com.twitterclient.hashtags.HashtagsPresenterImpl;
import projects.bryang8.com.twitterclient.hashtags.HashtagsRepository;
import projects.bryang8.com.twitterclient.hashtags.HashtagsRepositoryImpl;
import projects.bryang8.com.twitterclient.hashtags.ui.HashtagsView;
import projects.bryang8.com.twitterclient.hashtags.ui.OnItemClickListener;
import projects.bryang8.com.twitterclient.hashtags.adapters.HashtagsAdapter;
import projects.bryang8.com.twitterclient.hashtags.entities.Hashtag;
import projects.bryang8.com.twitterclient.lib.EventBus;

/**
 * Created by bryan_g8
 */

@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> provideItems() {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    HashtagsAdapter provideAdapter(Context context, List<Hashtag> items, OnItemClickListener clickListener) {
        return new HashtagsAdapter(context, items, clickListener);
    }

    @Provides
    @Singleton
    HashtagsView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsPresenter provideHashtagsPresenter(HashtagsView view, HashtagsInteractor interactor, EventBus eventBus) {
        return new HashtagsPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagsInteractor provideHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository provideHashtagsRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(client, eventBus);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
