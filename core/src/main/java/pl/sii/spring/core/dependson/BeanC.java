package pl.sii.spring.core.dependson;

import org.springframework.stereotype.Component;

@Component
public class BeanC {
    public BeanC() {
        System.out.println("BeanC");
    }
}
