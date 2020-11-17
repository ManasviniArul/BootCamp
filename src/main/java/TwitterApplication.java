import java.util.List;
import java.util.Scanner;

import twitter4j.*;

import twitter4j.conf.ConfigurationBuilder;

public class  TwitterApplication {

    public Twitter getTwitterInstance() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(" ")
                .setOAuthConsumerSecret(" ")
                .setOAuthAccessToken(" ")
                .setOAuthAccessTokenSecret(" ");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;

    }

    public void createTweet(Twitter twitter) throws TwitterException {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter tweet to be posted :");
        String tweet = s.nextLine();
        Status status = twitter.updateStatus(tweet);
        System.out.println("tweet posted ");
    }

    void getTimeline(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }

    public void directMessage(Twitter twitter) throws TwitterException {

        Scanner sa= new Scanner(System.in);

        System.out.println("Enter message to be sent : ");
        String msg = sa.nextLine();
        System.out.println("Enter recipient twitter id : ");
        String id = sa.nextLine();

        DirectMessage message=twitter.sendDirectMessage(id,msg);
        System.out.println("Sent: " +message.getText() + " to @" + message.getRecipientId());
    }

    public void getOneTimeLine(Twitter twitter) throws TwitterException {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter recipient twitter id : ");
        String id = s.nextLine();

        List<Status> status = twitter.getUserTimeline(id);
        for (Status st : status) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");

        }

    }

    public static void main(String args[]) throws TwitterException {

        TwitterApplication t=new TwitterApplication();
        Twitter obj = t.getTwitterInstance();

        System.out.println("What do you want to do in Twitter : \n1. post tweet \n2. send DM \n3. get home timeline "+
                "\n4. get a single user's timeline");
        Scanner s=new Scanner(System.in);
        int option=s.nextInt();

        switch(option) {
            case 1:
            {
                t.createTweet(obj);
                break;
            }
            case 2:
            {

                t.directMessage(obj);
                break;
            }
            case 3:
            {
                t.getTimeline(obj);
                break;
            }
            case 4:
            {
                t.getOneTimeLine(obj);
                break;
            }


        }


    }



}

