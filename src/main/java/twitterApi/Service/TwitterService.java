package twitterApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import twitter4j.TwitterException;
import twitterApi.model.TwitterModel;

import java.util.List;



@Service
public class TwitterService {

    @Autowired
    @Qualifier("TWITTER")
    TwitterInterface t;


    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<TwitterModel> getFeed() throws TwitterException {

        return t.get();
    }
}



