package twitterApi.Service;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterInterface {

    public List<String> get(Twitter twitter) throws TwitterException;

    public String post(Twitter twitter, String tweet) throws TwitterException;
}
