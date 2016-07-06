package projects.bryang8.com.twitterclient.lib.di;

import javax.inject.Singleton;

import dagger.Component;
import projects.bryang8.com.twitterclient.lib.di.LibsModule;

/**
 * Created by bryan_g8
 */


@Singleton @Component(modules = {LibsModule.class})
public interface LibsComponent {
}

