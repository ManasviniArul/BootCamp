package twitter.controller;

import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.util.List;

@RestController
@RequestMapping("/Twitter")
public class TwitterController {


    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping("/TimeLine")
    public List<Status> getTimeline() throws TwitterException {

        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;


    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        try {
            twitter.updateStatus(tweet);
            return "tweeted";
        }
        catch (TwitterException e) {
            e.printStackTrace();
            return "ERROR: tweet not posted";

        }
    }
}
