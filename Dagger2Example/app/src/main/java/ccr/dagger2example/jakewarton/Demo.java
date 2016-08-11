package ccr.dagger2example.jakewarton;

/**
 * Created by DELL on 8/11/2016.
 */
public class Demo {

    public static void main(String[] args) {
//        OkHttpClient client = new OkHttpClient();
//        TweeterApi tweeterApi = new TweeterApi(client);
//        String user = "Trong";
//
//        Tweeter tweeter = new Tweeter(tweeterApi, user);
//        tweeter.tweet("Hello every body");
//
//        TimeLine timeLine = new TimeLine(tweeterApi, user);
//        timeLine.loadMore(10);
//
//        for (String tweet: timeLine.getLsTweet()) {
//            System.out.println("tweet: " + tweet);
//        }

        TwitterComponent component = DaggerTwitterComponent.builder()
                .twitterModule(new TwitterModule("Trong"))
                .build();
        TimeLine timeLine = component.timeLine();
        Tweeter tweeter = component.tweeter();

        tweeter.tweet("Hello");
    }
}
