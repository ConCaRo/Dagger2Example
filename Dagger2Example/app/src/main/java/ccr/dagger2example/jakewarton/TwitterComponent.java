package ccr.dagger2example.jakewarton;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by DELL on 8/11/2016.
 */
@Singleton
@Component(modules =  {NetworkModule.class, TwitterModule.class})
public interface TwitterComponent {

    Tweeter tweeter();
    TimeLine timeLine();
}
