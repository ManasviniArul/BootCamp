package twitterApi;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import twitterApi.Service.TwitterInterfaceImpl;
import twitterApi.Service.TwitterInterfaceImpl1;

@Configuration
public class Config {
   /* @Bean
    @Primary
    public TwitterInterfaceImpl twitterInterfaceImpl(){
        return new TwitterInterfaceImpl();
    }
    @Bean
    public TwitterInterfaceImpl1 twitterInterfaceImpl1(){
        return new TwitterInterfaceImpl1();
    }*/
}

