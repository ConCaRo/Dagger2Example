package ccr.dagger2example.jakewarton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 8/11/2016.
 */
public class TimeLine {

    private List<String> lsTweet = new ArrayList<>();
    private TweeterApi tweeterApi;
    private String user;


    public TimeLine( TweeterApi tweeterApi, String user) {
        this.tweeterApi = tweeterApi;
        this.user = user;
    }

    public List<String> getLsTweet() {
        lsTweet.add("Hom nay vui");
        lsTweet.add("Nay an banh vui");
        lsTweet.add("Nay uong nuoc mia");
        return lsTweet;
    }

    public void loadMore(int amount) {

    }
}
