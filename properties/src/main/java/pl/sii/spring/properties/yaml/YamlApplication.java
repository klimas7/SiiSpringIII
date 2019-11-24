package pl.sii.spring.properties.yaml;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YamlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(YamlApplication.class);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
