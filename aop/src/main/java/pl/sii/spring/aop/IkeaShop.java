package pl.sii.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Component;


@Component
public class IkeaShop implements Shop {
    public static final Log log = LogFactory.getLog(IkeaShop.class);

    @Override
    public void buy() {
        log.info("Kupuję piękną komode");
        //throw new RuntimeException("upps!!");
    }

    @Override
    public void addToBasket(String name) {
        log.info("Add to basket: " + name);
    }
}
