package projects.bryang8.com.twitterclient.hashtags.di;


import javax.inject.Singleton;

import dagger.Component;
import projects.bryang8.com.twitterclient.TwitterAppModule;
import projects.bryang8.com.twitterclient.hashtags.ui.HashtagsFragment;
import projects.bryang8.com.twitterclient.lib.di.LibsModule;

/**
 * Created by bryan_g8
 */

@Singleton
@Component(modules = {HashtagsModule.class, LibsModule.class, TwitterAppModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}

