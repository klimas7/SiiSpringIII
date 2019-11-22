package pl.sii.spring.core.circular;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanB {
    private String message = "BeanB";
    private final BeanA beanA;

    public BeanB(@Lazy BeanA beanA) {
        this.beanA = beanA;
    }

    @PostConstruct
    public void print(){
        this.beanA.printMessage();
    }

    public void printMessage() {
        System.out.println(message);
    }
}
