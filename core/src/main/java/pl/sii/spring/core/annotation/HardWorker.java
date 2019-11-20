package pl.sii.spring.core.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.sii.spring.core.xml.Worker;

import java.util.UUID;

@Component
@Scope(value = "singleton")
public class HardWorker implements Worker {
    private String uuid;

    public HardWorker() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doWork() {
        System.out.println("I'am hard worker nr: " + uuid);
    }
}
