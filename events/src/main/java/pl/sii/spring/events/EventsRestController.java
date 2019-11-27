package pl.sii.spring.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventsRestController {
    private static final Log log = LogFactory.getLog(EventsRestController.class);
    private ApplicationEventPublisher applicationEventPublisher;

    public EventsRestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping("/processMessage/{message}")
    public void processMessage(@PathVariable String message) {
        log.info("Process message: " + message);
        applicationEventPublisher.publishEvent(new MessageEvent(this, message));
        log.info("After publish event");
    }
}
