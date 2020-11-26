package twitterApi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitterApi.Service.TwitterService;

import java.util.List;

@RestController
@RequestMapping("/Twitter")
public class TwitterController {

    @Value("${demo.consumerKey}")
    String consumerKey;
    @Value("${demo.consumerSecret}")
    String consumerSecret;
    @Value("${demo.accessToken}")
    String accessToken;
    @Value("${demo.accessTokenSecret}")
    String accessTokenSecret;



    public Twitter getTwitterInstance()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        return twitter;
    }

     TwitterService t = new TwitterService();

    @GetMapping("/TimeLine")
    public List<String> getTimeline() throws TwitterException{

        Twitter twitter=getTwitterInstance();
        return t.getFeed(twitter);


    }

    @PostMapping("/postTweet/{tweet}")
    public String postTweet(@PathVariable(value = "tweet") String tweet) throws TwitterException {

        Twitter twitter=getTwitterInstance();
        return t.postMessage(twitter,tweet);


    }
}

