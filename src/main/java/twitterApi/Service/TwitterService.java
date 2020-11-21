package twitterApi.Service;

import twitter4j.TwitterException;

import java.util.List;

public class TwitterService {

    TwitterInterface t = new TwitterInterfaceImpl();

    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<String> getFeed() throws TwitterException {

        return t.get();
    }


}
