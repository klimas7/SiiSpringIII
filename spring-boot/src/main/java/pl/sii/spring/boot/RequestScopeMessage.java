package pl.sii.spring.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeMessage {
    private static Log log = LogFactory.getLog(RequestScopeMessage.class);
    private AtomicInteger counter = new AtomicInteger(0);

    public RequestScopeMessage() {
        log.info("Create: " + RequestScopeMessage.class.getName());
    }

    public String getMessage() {
        String message = "RequestScope: " + counter.incrementAndGet();
        log.info(message);
        return message;
    }
}
