package pl.sii.spring.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static pl.sii.spring.jms.QueueName.MESSAGE_QUEUE_OBJECT;
import static pl.sii.spring.jms.QueueName.MESSAGE_QUEUE_TEXT;

@Component
public class QueueReceiver {
    private static final Log log = LogFactory.getLog(QueueReceiver.class);

    @JmsListener(destination = MESSAGE_QUEUE_TEXT)
    public void receiveText(@Payload String text, @Headers MessageHeaders headers) {
        log.info("Text from receiver: " + text);
        logHeaders(headers);
    }

    @JmsListener(destination = MESSAGE_QUEUE_OBJECT)
    public void receiveMessage(@Payload MessageInfo messageInfo, @Headers MessageHeaders headers) {
        log.info("Message from receiver: " + messageInfo);
        logHeaders(headers);
    }

    private void logHeaders(MessageHeaders headers) {
        headers.forEach((key, value) -> log.info("Header: " + key + " : " + value));
    }
}
