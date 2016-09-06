package ccr.dagger2example.jakewarton;

/**
 * Created by DELL on 8/11/2016.
 */
public class Demo {

    public static void main(String[] args) {

        // 1
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


        // 2
//        TwitterComponent component = DaggerTwitterComponent.builder()
//                .twitterModule(new TwitterModule("Trong"))
//                .build();
//        TimeLine timeLine = component.timeLine();
//        Tweeter tweeter = component.tweeter();
//
//        tweeter.tweet("Hello every body");
//
//        for (String tweet : timeLine.getLsTweet()) {
//            System.out.println("tweet: " + tweet);
//        }

        // 3
        TwitterComponent component = DaggerTwitterComponent.builder().twitterModule(new TwitterModule("Trong"))
                .build();
        TwitterApplication twitterApplication = new TwitterApplication();
        component.injectApplication(twitterApplication);

        twitterApplication.run();


    }
}
