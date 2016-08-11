package ccr.dagger2example.jakewarton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DELL on 8/11/2016.
 */
@Module
public class NetworkModule {

    @Provides @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }
}
