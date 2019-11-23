package pl.sii.spring.profiles;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean(name = "message")
    @Lazy
    @Profile("test")
    public Message messageTest() {
        return new MessageImpl("SimpleBeanInTest");
    }

    @Bean(name = "message")
    @Lazy
    @Profile("dev")
    public Message message() {
        return new MessageImpl("SimpleBean");
    }

    //ConfigurationClassBeanDefinitionReader -> loadBeanDefinitionsForBeanMethod -> this.conditionEvaluator.shouldSkip
    // ConditionEvaluator -> shouldSkip
}
