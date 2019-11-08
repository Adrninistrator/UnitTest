package test.testframework.spring.test;

import com.test.service.TestService2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import test.testframework.spring.base.TestSpringBase;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

//使Spring Context重新加载
@DirtiesContext(classMode = BEFORE_CLASS)
public class TestSpring3 extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpring3.class);

    @Autowired
    private TestService2 testService2;

    @Test
    public void test1() {

        logger.info("testService2 hashCode: {}", System.identityHashCode(testService2));
    }

    @Test
    public void test2() {

        logger.info("testService2 hashCode: {}", System.identityHashCode(testService2));
    }
}
