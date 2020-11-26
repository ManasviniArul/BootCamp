package twitterApi.Service;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class TwitterService {

    public TwitterService() {}

    TwitterInterface t = new TwitterInterfaceImpl();

    public String postMessage(Twitter twitter, String msg) throws TwitterException {

        return t.post(twitter,msg);
    }

    public List<String> getFeed(Twitter twitter) throws TwitterException {

        return t.get(twitter);
    }


}
