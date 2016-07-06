package projects.bryang8.com.twitterclient.images.di;


import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import projects.bryang8.com.twitterclient.api.CustomTwitterApiClient;
import projects.bryang8.com.twitterclient.images.ImagesInteractor;
import projects.bryang8.com.twitterclient.images.ImagesInteractorImpl;
import projects.bryang8.com.twitterclient.images.ImagesPresenter;
import projects.bryang8.com.twitterclient.images.ImagesPresenterImpl;
import projects.bryang8.com.twitterclient.images.ImagesRepository;
import projects.bryang8.com.twitterclient.images.ImagesRepositoryImpl;
import projects.bryang8.com.twitterclient.images.ui.ImagesView;
import projects.bryang8.com.twitterclient.images.ui.OnItemClickListener;
import projects.bryang8.com.twitterclient.images.adapters.ImagesAdapter;
import projects.bryang8.com.twitterclient.images.entities.Image;
import projects.bryang8.com.twitterclient.lib.EventBus;
import projects.bryang8.com.twitterclient.lib.ImageLoader;

/**
 * Created by bryan_g8
 */

@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Image> provideItems() {
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    ImagesAdapter provideAdapter(List<Image> items, OnItemClickListener clickListener, ImageLoader imageLoader) {
        return new ImagesAdapter(items, clickListener, imageLoader);
    }

    @Provides
    @Singleton
    ImagesView provideImagesView() {
        return this.view;
    }

    @Provides
    @Singleton
    ImagesPresenter provideImagesPresenter(ImagesView view, ImagesInteractor interactor, EventBus eventBus) {
        return new ImagesPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    ImagesInteractor provideImagesInteractor(ImagesRepository repository) {
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository provideImagesRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new ImagesRepositoryImpl(client, eventBus);
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
