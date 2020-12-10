package twitterApi.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;
import twitterApi.model.TwitterModel;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TwitterService {

    //TwitterInterface t = new TwitterInterfaceImpl();
    @Inject
    TwitterInterface t;


    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<TwitterModel> getFeed() throws TwitterException {

        return t.get();
    }
}



