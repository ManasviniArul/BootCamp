package twitterApi.Service;

import twitter4j.TwitterException;

import java.util.List;

public interface TwitterService {

    String postMessage(String msg) throws TwitterException;

    List<String> getFeed() throws TwitterException;
}
