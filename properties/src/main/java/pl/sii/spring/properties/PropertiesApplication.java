package pl.sii.spring.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SiiSpringProperty.class)
public class PropertiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertiesApplication.class);
    }
}
