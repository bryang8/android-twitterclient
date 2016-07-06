package projects.bryang8.com.twitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import projects.bryang8.com.twitterclient.images.ui.ImagesFragment;
import projects.bryang8.com.twitterclient.lib.di.LibsModule;

/**
 * Created by bryan_g8
 */


@Singleton
@Component(modules = {ImagesModule.class, LibsModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    //ImagesPresenter getPresenter();
}

