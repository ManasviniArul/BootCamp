package twitterApi.Service;

import twitter4j.TwitterException;

import java.util.List;

public interface TwitterInterface {

    public List<String> get() throws TwitterException;

    public String post(String tweet) throws TwitterException;
}
