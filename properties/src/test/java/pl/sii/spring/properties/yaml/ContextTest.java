package pl.sii.spring.properties.yaml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContextTest {
    @Autowired
    private YAMLConfig yamlConfig;

    @Test
    public void propertyTest() {
        assertEquals("test-YAML", yamlConfig.getName());
    }
}
