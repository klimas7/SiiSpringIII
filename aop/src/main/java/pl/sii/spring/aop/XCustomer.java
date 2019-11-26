package pl.sii.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class XCustomer {
    public static final Log log = LogFactory.getLog(XCustomer.class);

    @Before("execution(* pl.sii.spring.aop.Shop.buy(..))")
    public void chose() {
        log.info("chose()");
    }

    @After("execution(* pl.sii.spring.aop.Shop.buy())")
    public void checkPrice() {
        log.info("checkPrice()");
    }

    @AfterReturning("execution(* pl.sii.spring.aop.Shop.buy())")
    public void transport() {
        log.info("transport()");
    }

    @AfterThrowing("execution(* pl.sii.spring.aop.Shop.buy(..))")
    public void somethingWrong() {
        log.info("somethingWrong()");
    }
}
