import java.util.List;
import java.util.Scanner;

import twitter4j.*;


public class  Twitter1 {

    public void createTweet() throws TwitterException {

        Twitter twitter=TwitterFactory.getSingleton();
        Scanner s= new Scanner(System.in);
        System.out.println("Enter tweet to be posted :");
        String tweet = s.nextLine();
        twitter.updateStatus(tweet);
        System.out.println("tweet posted");
    }

    void getTimeline() throws TwitterException {

        Twitter twitter=TwitterFactory.getSingleton();
        Paging page = new Paging(1,5);
        List<Status> statuses = twitter.getHomeTimeline(page);
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------>" + st.getText()+"\n");
        }
    }

    public void directMessage() throws TwitterException {

        Scanner s=new Scanner(System.in);
        System.out.println("Enter message to be sent : ");
        String msg = s.nextLine();
        System.out.println("Enter recipient twitter id : ");
        String id = s.nextLine();

        Twitter twitter=TwitterFactory.getSingleton();
        DirectMessage message=twitter.sendDirectMessage(id,msg);
        System.out.println("Sent: " +message.getText() + " to @" + message.getRecipientId());
    }

    public void getOneTimeLine() throws TwitterException {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter recipient twitter id : ");
        String id = s.nextLine();

        Twitter twitter=TwitterFactory.getSingleton();
        List<Status> status = twitter.getUserTimeline(id);
        for (Status st : status) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");

        }

    }

    public static void main(String args[]) throws TwitterException {

        Twitter1 t=new Twitter1();

        System.out.println("What do you want to do in Twitter : \n1. post tweet \n2. send DM \n3. get home timeline "+
                "\n4. get a single user's timeline");
        Scanner s=new Scanner(System.in);
        int option=s.nextInt();

        switch(option) {
            case 1:
            {
                t.createTweet();
                break;
            }
            case 2:
            {
                t.directMessage();
                break;
            }
            case 3:
            {
                t.getTimeline();
                break;
            }
            case 4:
            {
                t.getOneTimeLine();
                break;
            }


        }


    }



}
