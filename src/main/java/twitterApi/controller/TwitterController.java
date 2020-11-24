package twitterApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;
import twitterApi.Service.TwitterService;

import java.util.List;

@RestController
@RequestMapping("/Twitter")
public class TwitterController {


    //Twitter twitter = TwitterFactory.getSingleton();
    Logger log = LoggerFactory.getLogger(TwitterController.class);
     TwitterService t = new TwitterService();

    @GetMapping("/TimeLine")
    public List<String> getTimeline() throws TwitterException{

        log.info("running successfully !!");
        return t.getFeed();
        //System.out.println("doneee");

    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        log.info("post tweet method is called");
        log.trace("trace");
        return t.postMessage(tweet);


    }
}

