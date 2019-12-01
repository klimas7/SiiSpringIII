package pl.sii.spring.aop;

import org.aspectj.lang.annotation.Pointcut;

public interface Customer {
    @Pointcut("execution(* pl.sii.spring.aop.Shop.buy(..))")
    default void buy() {
    }

    @Pointcut("execution(* pl.sii.spring.aop.Shop.addToBasket(String)) && args(name)")
    default void addToBasket(String name) {
    }
}
