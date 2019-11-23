package pl.sii.spring.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class SpringConfig {

    @Value("${extraMessage}")
    private String extraMessage;

    @Bean(name = "message")
    @Lazy
    @Profile("test")
    public Message messageTest() {
        return new MessageImpl("SimpleBeanInTest: " + extraMessage);
    }

    @Bean(name = "message")
    @Lazy
    @Profile("dev")
    public Message message() {
        return new MessageImpl("SimpleBean: " + extraMessage);
    }

    //ConfigurationClassBeanDefinitionReader -> loadBeanDefinitionsForBeanMethod -> this.conditionEvaluator.shouldSkip
    // ConditionEvaluator -> shouldSkip
}
