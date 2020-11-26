package twitterApi.resource;

import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;
import twitterApi.Service.TwitterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/Twitter")
public class TwitterResource {


    //Twitter twitter = TwitterFactory.getSingleton();

     TwitterServiceImpl t = new TwitterServiceImpl();

    @GetMapping("/TimeLine")
    public List<String> getTimeline() throws TwitterException{

         return t.getFeed();
        //System.out.println("doneee");

    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        return t.postMessage(tweet);


    }
}

