package projects.bryang8.com.twitterclient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bryan_g8.
 */

@Singleton @Component(modules = {TwitterAppModule.class})
public interface TwitterAppComponent {
}

