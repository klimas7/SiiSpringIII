package pl.sii.spring.profiles;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageHandler {
    private Message message;

    public MessageHandler(Message message) {
        this.message = message;
    }

    @PostConstruct
    public void send() {
        message.sendMessage();
    }
}
