package twitterApi;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Main {


        static{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            System.setProperty("current.date", dateFormat.format(new Date()));
        }

        static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("APP started");
        SpringApplication.run(Main.class, args);
    }

}
