package twitterApi.Service;

import twitter4j.TwitterException;
import twitterApi.model.TwitterModel;

import java.util.List;

public class TwitterService {

    TwitterInterface t = new TwitterInterfaceImpl();

    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<TwitterModel> getFeed() throws TwitterException {

        return t.get();
    }


}
