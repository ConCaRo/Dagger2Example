package ccr.dagger2example.jakewarton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DELL on 8/11/2016.
 */
@Module
public class TwitterModule {

    private String user;

    public TwitterModule(String user) {
        this.user = user;
    }

    @Provides @Singleton
    public Tweeter provideTwitter(TweeterApi tweeterApi) {
        return new Tweeter(tweeterApi, user);
    }

    @Provides @Singleton
    public TimeLine provideTimeLine(TweeterApi tweeterApi) {
        return new TimeLine(tweeterApi, user);
    }
}
