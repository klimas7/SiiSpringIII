package pl.sii.spring.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopeMessage {
    private static Log log = LogFactory.getLog(SessionScopeMessage.class);
    private AtomicInteger counter = new AtomicInteger(0);

    public SessionScopeMessage() {
        log.info("Create " + SessionScopeMessage.class.getName());
    }

    public String getMessage() {
        String message = "SessionScope: " + counter.incrementAndGet();
        log.info(message);
        return message;
    }
}
