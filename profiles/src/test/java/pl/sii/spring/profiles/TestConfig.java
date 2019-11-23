package pl.sii.spring.profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("pl.sii.spring.profiles")
@PropertySource("classpath:application-test.properties")
class TestConfig {

}