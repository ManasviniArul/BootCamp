package twitterApi.Service;

import twitter4j.TwitterException;
import twitterApi.dao.TwitterDao;
import twitterApi.dao.TwitterDaoImpl;

import java.util.List;

public class TwitterServiceImpl implements TwitterService{

    TwitterDaoImpl t = new TwitterDaoImpl();

    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<String> getFeed() throws TwitterException {

        return t.get();
    }


}
