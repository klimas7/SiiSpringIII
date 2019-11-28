package pl.sii.spring.jms;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import static pl.sii.spring.jms.QueueName.MESSAGE_QUEUE_OBJECT;
import static pl.sii.spring.jms.QueueName.MESSAGE_QUEUE_TEXT;

@Component
public class MessageServiceImpl implements MessageService {


    private static final Log log = LogFactory.getLog(MessageServiceImpl.class);

    private JmsOperations jmsOperations;

    public MessageServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendMessage(String message) {
        jmsOperations.convertAndSend(MESSAGE_QUEUE_TEXT, message);
    }

    @Override
    public String getMessage() {
        Message receive = jmsOperations.receive(MESSAGE_QUEUE_TEXT);
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
        jmsOperations.convertAndSend(MESSAGE_QUEUE_OBJECT, messageInfo);
    }

    @Override
    public MessageInfo getMessageInfo() {
//        return (MessageInfo) jmsOperations.receiveAndConvert("message.queue.object");
        return (MessageInfo) jmsOperations.receiveAndConvert(MESSAGE_QUEUE_OBJECT);
    }

    @Override
    public void sendTopic(String topic) {
        jmsOperations.convertAndSend(new ActiveMQTopic("sii.topic"), topic);
    }
}
