package twitterApi.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;

public class TwitterInterfaceImpl implements TwitterInterface {

    Logger logger = LoggerFactory.getLogger(TwitterInterfaceImpl.class);

    Twitter twitter = TwitterFactory.getSingleton();

    public List<String> get() throws TwitterException {

        List<String> temp = new ArrayList<>();
        List<Status> s = twitter.getHomeTimeline();

        for(Status status:s) {
            temp.add(status.getText());
        }
        return temp;

    }



    public String post(String tweet) throws TwitterException {

        try {
            twitter.updateStatus(tweet);
            return "tweeted";
        }
        catch(TwitterException e) {
            logger.error("duplicate msg not accepted");
            e.printStackTrace();
            return "error";
        }
    }
}

