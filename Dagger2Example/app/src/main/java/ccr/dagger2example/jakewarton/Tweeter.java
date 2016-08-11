package ccr.dagger2example.jakewarton;

/**
 * Created by DELL on 8/11/2016.
 */
public class Tweeter {

    private TweeterApi tweeterApi;
    private String user;

    public Tweeter(TweeterApi tweeterApi, String user) {
        this.user = user;
        this.tweeterApi = tweeterApi;
    }

    public void tweet(String tweet) {
        tweeterApi.postTweet(user, tweet);
    }
}
