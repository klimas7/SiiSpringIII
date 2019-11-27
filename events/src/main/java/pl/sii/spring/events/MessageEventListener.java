package pl.sii.spring.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    private static final Log log = LogFactory.getLog(MessageEventListener.class);
    @Override
    public void onApplicationEvent(MessageEvent event) {
        log.info("Listen a message: " + event.getMessage() + " from source: " + event.getSource());

    }
}
