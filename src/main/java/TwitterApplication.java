import java.util.List;
import java.util.Scanner;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

public class  TwitterApplication {

    public Twitter getTwitterinstance() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(" ")
                .setOAuthConsumerSecret(" ")
                .setOAuthAccessToken(" ")
                .setOAuthAccessTokenSecret(" ");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;

    }

    public void createTweet(Twitter twitter, String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("tweet posted");
    }

    void getTimeline(Twitter twitter) throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }

    public static void main(String args[]) throws TwitterException {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter tweet to be posted :");
        String tweet = s.nextLine();
        TwitterApplication t=new TwitterApplication();
        Twitter obj = t.getTwitterinstance();

        t.createTweet(obj, tweet);
        t.getTimeline(obj);
    }



}

