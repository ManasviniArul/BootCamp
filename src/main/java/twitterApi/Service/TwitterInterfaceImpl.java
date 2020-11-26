package twitterApi.Service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;

public class TwitterInterfaceImpl implements TwitterInterface {

    public TwitterInterfaceImpl() {}

    public List<String> get(Twitter twitter) throws TwitterException {

        List<String> temp = new ArrayList<>();
        List<Status> s = twitter.getHomeTimeline();

        for(Status status:s) {
            temp.add(status.getText());
        }
        return temp;

    }



    public String post(Twitter twitter, String tweet) throws TwitterException {

       twitter.updateStatus(tweet);
        return "tweeted";
    }
}

