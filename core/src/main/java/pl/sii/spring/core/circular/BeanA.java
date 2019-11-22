package pl.sii.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private String message = "BeanA";
    private BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
        this.beanB.printMessage();
    }
    public void printMessage() {
        System.out.println(message);
    }
}
