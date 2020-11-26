package twitterApi.dao;

import twitter4j.TwitterException;

import java.util.List;

public interface TwitterDao {

    List<String> get() throws TwitterException;

    String post(String tweet) throws TwitterException;
}
