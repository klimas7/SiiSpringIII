package pl.sii.spring.core.diff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import javax.inject.Inject;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class DiffInjectTest {
    /*
     * - Type
     * - Qualifier
     * - name
     */
    @Inject
    @Qualifier("triangle")
    private Shape square;

    @Test
    public void startContextTest() {
        System.out.println(square.description());
    }
}
