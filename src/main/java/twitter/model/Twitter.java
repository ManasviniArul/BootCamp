package twitter.model;

public class Twitter {

    private String tweet;

    public Twitter(String tweet) {
        this.tweet = tweet;
    }


    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "Twitter{" +
                "tweet='" + tweet + '\'' +
                '}';
    }
}
