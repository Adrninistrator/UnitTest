package adrninistrator.test.testframework.spring.test.context;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestService2;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 默认情况下，Spring Context会使用缓存
public class TestSpringReuseContext1 extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringReuseContext1.class);

    @Autowired
    private TestService2 testService2;

    @Before
    public void init() {
        assertNotNull(testService2);

        logger.info("testService2 hashCode: {}", System.identityHashCode(testService2));
    }

    @Test
    public void test() {
        String str = testService2.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
