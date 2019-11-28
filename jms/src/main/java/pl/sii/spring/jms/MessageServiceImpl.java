package pl.sii.spring.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MessageServiceImpl implements MessageService {
    private static final String QUEUE_PLAIN_TEXT = "message.queue.plainText";

    private static final Log log = LogFactory.getLog(MessageServiceImpl.class);

    private JmsOperations jmsOperations;

    public MessageServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendMessage(String message) {
        jmsOperations.send(QUEUE_PLAIN_TEXT, session -> session.createTextMessage(message));
    }

    @Override
    public String getMessage() {
        Message receive = jmsOperations.receive(QUEUE_PLAIN_TEXT);
        try {
            return ((TextMessage)receive).getText();
        } catch (JMSException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public void sendMessageInfo(MessageInfo messageInfo) {
        //jmsOperations.convertAndSend("message.queue.object", messageInfo);
        jmsOperations.convertAndSend(messageInfo);
    }

    @Override
    public MessageInfo getMessageInfo() {
//        return (MessageInfo) jmsOperations.receiveAndConvert("message.queue.object");
        return (MessageInfo) jmsOperations.receiveAndConvert();
    }
}
