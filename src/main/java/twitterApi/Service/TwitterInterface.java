package twitterApi.Service;

import twitter4j.TwitterException;
import twitterApi.model.TwitterModel;

import java.util.List;

public interface TwitterInterface {

    public List<TwitterModel> get() throws TwitterException;

    public String post(String tweet) throws TwitterException;
}
