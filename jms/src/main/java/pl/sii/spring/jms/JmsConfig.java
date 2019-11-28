package pl.sii.spring.jms;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    //After add @EnableJms

//    @Value("${spring.activemq.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return new ActiveMQConnectionFactory(brokerUrl);
//    }

//    @Bean
//    public JmsTemplate jmsTemplate(MessageConverter messageConverter, ConnectionFactory connectionFactory) {
//        JmsTemplate template = new JmsTemplate(connectionFactory);
//        template.setDefaultDestinationName(MESSAGE_QUEUE_OBJECT);
//        template.setMessageConverter(messageConverter);
//        return template;
//    }

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("object-type");
        return mappingJackson2MessageConverter;
    }
}
