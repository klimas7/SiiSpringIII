package pl.sii.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.Delimiter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
@PropertySources({
        @PropertySource("classpath:sii2.properties"),
        @PropertySource("classpath:sii.properties"),
})
public class PropertiesComponent {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private Environment env;

    @Value("${sii.spring.p1}")
    private String p1;

    @Value("${sii.spring.p2:test.p2}")
    private String p2;
    //PropertyPlaceholderHelper -> PropertySourcesPropertyResolver

    @Value("${sii.spring.p3}")
    private List<String> p3;
    //DelimitedStringToCollectionConverter

    @Delimiter(";")
    @Value("${sii.spring.p3a}")
    private List<String> p3a;

    @Value("#{'${sii.spring.p3b}'.split(';')}")
    private List<String> p3b;

    @Value("${sii.spring.p4}")
    private String p4;

    @Value("${sii.spring.p4a}")
    private String p4a;

    @Value("#{${sii.spring.p5} + 10}")
    private String p5;

    @Value("#{systemProperties['user.name']}")
    private String userName;

//    @Value("#{testProperty['property']}")
    @Value("#{testProperty.property}")
    private String propertyFromClass;
    //StandardBeanExpressionResolver -> SpelExpression -> ... -> Indexer -> ReflectivePropertyAccessor

    @Value("#{propertyGenerator.generate('${sii.spring.p6}')}")
    private Map<String, String> p6;

    @Value("#{${sii.spring.p6a}}")
    private Map<String, String> p6a;

    @Autowired
    private SiiSpringProperty siiSpringProperty;

    @PostConstruct
    public void printProperties() {
        logger.info("Print properties");
        logger.info("sii.spring.p1: " + p1);
        logger.info("sii.spring.p2: " + p2);
        logger.info("sii.spring.p3: " + p3);
        logger.info("sii.spring.p3a: " + p3a);
        logger.info("sii.spring.p3b: " + p3b);
        logger.info("sii.spring.p4: " + p4);
        logger.info("sii.spring.p4a: " + p4a);
        logger.info("sii.spring.p5: " + p5);
        logger.info("userName: " + userName);
        logger.info("propertyFromClass " + propertyFromClass);
        logger.info("userHome: " + env.getProperty("user.home"));
        logger.info("active profile: " + Arrays.asList(env.getActiveProfiles()));
        logger.info("default profile: " + Arrays.asList(env.getDefaultProfiles()));
        logger.info("sii.spring.p6: " + p6);
        logger.info("sii.spring.p6: " + p6a);

        logger.info("siiSpringProperty.p1: " + siiSpringProperty.getP1());
        logger.info("siiSpringProperty.p2: " + siiSpringProperty.getP2());
        logger.info("siiSpringProperty.p3: " + Arrays.asList(siiSpringProperty.getP3()));
        logger.info("siiSpringProperty.p3a: " + siiSpringProperty.getP3a());
        logger.info("siiSpringProperty.p4: " + siiSpringProperty.getP4());
        logger.info("siiSpringProperty.p4a: " + siiSpringProperty.getP4a());
        logger.info("siiSpringProperty.p5: " + siiSpringProperty.getP5());
        logger.info("siiSpringProperty.p6: " + siiSpringProperty.getP6());
        logger.info("siiSpringProperty.p6a: " + siiSpringProperty.getP6b());
    }
}
