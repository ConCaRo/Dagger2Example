package ccr.dagger2example.jakewarton;

import javax.inject.Inject;

/**
 * Created by DELL on 8/12/2016.
 */
public class TwitterApplication implements  Runnable {

    @Inject Tweeter tweeter;
    @Inject TimeLine timeLine;


//    private final Tweeter tweeter;
//    private final TimeLine timeLine;
//
//    @Inject
//    public TwitterApplication(Tweeter tweeter, TimeLine timeLine) {
//        this.tweeter = tweeter;
//        this.timeLine = timeLine;
//    }

    @Override
    public void run() {
        tweeter.tweet("Hello every body");

        for (String tweet : timeLine.getLsTweet()) {
            System.out.println("tweet: " + tweet);
        }
    }
}
