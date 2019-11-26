package pl.sii.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Aspect
@Component
public class VerySmartCustomer {
    public static final Log log = LogFactory.getLog(VerySmartCustomer.class);
    Map<String, Integer> thingsCount = new HashMap<>();

    @Pointcut("execution(* pl.sii.spring.aop.Shop.buy(..))")
    public void buy() {
    }

    @Pointcut("execution(* pl.sii.spring.aop.Shop.addToBasket(String)) && args(name)")
    public void addToBasket(String name) {
    }

    @Before("addToBasket(name)")
    public void countThings(String name) {
        int count = getThingsCount(name);
        thingsCount.put(name, count + 1);
    }

    private int getThingsCount(String name) {
        return Optional.ofNullable(thingsCount.get(name)).orElse(0);
    }

    public void showCounts() {
        thingsCount.forEach((key, value) -> log.info(key + " " + value));
    }

    @Around("buy()")
    public void shopping(ProceedingJoinPoint pjp) {
        log.info("Before shopping");

        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            log.error(throwable);
        }

        log.info("After shopping");
    }
}
