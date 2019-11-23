package pl.sii.spring.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class MessageHandler {
    @Autowired
    Environment environment;

    private Message message;

    public MessageHandler(Message message) {
        this.message = message;
    }

    @PostConstruct
    public void send() {
        Arrays.asList(environment.getActiveProfiles()).forEach(System.out::println);
        message.sendMessage();
    }
}
