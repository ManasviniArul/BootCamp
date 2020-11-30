package twitterApi.Service;

import twitter4j.TwitterException;
import twitterApi.model.TwitterModel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwitterService {

    TwitterInterface t = new TwitterInterfaceImpl();

    public String postMessage(String msg) throws TwitterException {

        return t.post(msg);
    }

    public List<TwitterModel> getFeed() throws TwitterException {

        return t.get();
    }


    public List<TwitterModel> timeline() throws TwitterException {

        List<TwitterModel> list = t.get();

        //return list.stream().sorted(Comparator.comparing(TwitterModel::getName)).collect(Collectors.toList());
        //return list.stream().filter(s -> s.getName().startsWith("A")).collect(Collectors.toList());
        list.stream().sorted(Comparator.comparing(TwitterModel::getName)).forEach(System.out::println);
        return list;

    }

    public List<String> map() throws TwitterException {

        List<TwitterModel> list = t.get();

        return list.stream().map(s -> s.getName()).limit(2).collect(Collectors.toList());

    }


    public HashMap<String, TwitterModel> post(List<TwitterModel> twitterModel) {

        HashMap<String, TwitterModel> list = new HashMap<>();
        List<String> names=twitterModel.stream().map(item-> {
            list.put(item.getId(),item);
            return item.getName();
        }).collect(Collectors.toList());
        return list;
    }
}
