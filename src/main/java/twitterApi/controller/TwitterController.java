package twitterApi.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;
import twitterApi.Service.TwitterService;
import twitterApi.model.TwitterModel;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Twitter")
public class TwitterController {


    //Twitter twitter = TwitterFactory.getSingleton();

    @Inject
    TwitterService t;

    @GetMapping("/TimeLine")

    public List<TwitterModel> getTimeline() throws TwitterException{

        return t.getFeed();


    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        return t.postMessage(tweet);
    }


}

