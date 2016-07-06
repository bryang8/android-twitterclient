package projects.bryang8.com.twitterclient.lib;

/**
 * Created by bryan_g8
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
