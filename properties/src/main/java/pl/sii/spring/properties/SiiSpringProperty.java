package pl.sii.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.Delimiter;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "sii.spring")
public class SiiSpringProperty {
    private String p1;
    private String p2;
    private String[] p3;
    @Delimiter(";")
    private List<String> p3a;

    private String p4;
    private String p4a;

    private Integer p5;

    private String[] p6;

    private String p6b;

    @Autowired
    private PropertyGenerator propertyGenerator;

    @Autowired
    private TestProperty testProperty;

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String[] getP3() {
        return p3;
    }

    public void setP3(String[] p3) {
        this.p3 = p3;
    }

    public List<String> getP3a() {
        return p3a;
    }

    public void setP3a(List<String> p3a) {
        this.p3a = p3a;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP4a() {
        return p4a;
    }

    public void setP4a(String p4a) {
        this.p4a = p4a;
    }

    public Integer getP5() {
        return p5 + 10;
    }

    public void setP5(Integer p5) {
        this.p5 = p5;
    }

    public Map<String, String> getP6() {
        return propertyGenerator.generate(p6);
    }

    public void setP6(String[] p6) {
        this.p6 = p6;
    }

    public Map getP6b() {
        StandardEvaluationContext testContext = new StandardEvaluationContext(testProperty);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(p6b);
        return exp.getValue(testContext, Map.class);
    }

    public void setP6b(String p6b) {
        this.p6b = p6b;
    }
}
