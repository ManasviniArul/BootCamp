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

        return twitter.getHomeTimeline();

    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        twitter.updateStatus(tweet);
        return "tweeted";
    }
}
