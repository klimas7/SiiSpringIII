package pl.sii.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SmartCustomer {
    public static final Log log = LogFactory.getLog(SmartCustomer.class);

    @Pointcut("execution(* pl.sii.spring.aop.Shop.buy(..))")
    public void buy() {

    }

    @Before("buy()")
    public void chose() {
        log.info("chose()");
    }

    @After("buy()")
    public void checkPrice() {
        log.info("checkPrice()");
    }

    @AfterReturning("buy()")
    public void transport() {
        log.info("transport()");
    }

    @AfterThrowing("buy()")
    public void somethingWrong() {
        log.info("somethingWrong()");
    }
}
