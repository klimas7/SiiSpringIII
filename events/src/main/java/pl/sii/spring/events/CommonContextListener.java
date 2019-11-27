package pl.sii.spring.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class CommonContextListener {
    private static Log log = LogFactory.getLog(CommonContextListener.class);

    @EventListener
    public void refreshContextEvent(ContextRefreshedEvent cre) {
        log.info("Refresh event: " + cre.getSource());
    }

    @EventListener
    public void startedContextEvent(ContextStartedEvent cse) {
        log.info("Started event: " + cse.getSource());
    }

    @EventListener
    public void stoppedContextEvent(ContextStoppedEvent cse) {
        log.info("Stopped event: " + cse.getSource());
    }

    @EventListener(classes = {ContextClosedEvent.class, ApplicationReadyEvent.class})
    public void otherContextEvents(ApplicationEvent event) {
        log.info("Other event: " + event.getSource());
    }

}
