package pl.sii.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SelfServiceShopImpl implements SelfServiceShop {
    public static final Log log = LogFactory.getLog(SelfServiceShopImpl.class);
    @Override
    public void selfBuy() {
        log.info("selfBuy()");
    }
}
