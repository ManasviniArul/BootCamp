package twitterApi.controller;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;

import org.junit.Test;
import org.junit.runner.RunWith;

import twitter4j.TwitterException;
import twitterApi.Service.TwitterInterface;
import twitterApi.Service.TwitterService;

import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;



@RunWith(EasyMockRunner.class)
public class TwitterControllerTest {

    @Mock
    TwitterInterface i;

    @TestSubject
    TwitterService t = new TwitterService();


    @Test
    public void getTest() throws TwitterException {
        expect(i.get()).andReturn(Collections.singletonList("time line from twitter"));
        replay(i);
        List<String> s = t.getFeed();
        assertEquals(Collections.singletonList("time line from twitter"),s);

    }


    @Test
    public void postTest() throws TwitterException {

        expect(i.post("bbjk")).andReturn("tweeted");
        replay(i);
        String a = t.postMessage("bbjk");
        assertEquals("tweeted",a);


    }



}