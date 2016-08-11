package ccr.dagger2example.jakewarton;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DELL on 8/11/2016.
 */
@Singleton
public class TweeterApi {

    final OkHttpClient client;

    @Inject
    public TweeterApi(OkHttpClient client) {
        this.client = client;
    }

    public void postTweet(String user, String tweet) {
        client.sendRequest(user  + " " + tweet);
    }
}
