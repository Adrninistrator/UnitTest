package adrninistrator.test.testframework.spring.test.context;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestService2;
import com.adrninistrator.service.TestServiceA1;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 默认情况下，Spring Context会使用缓存
public class TestSpringReuseContext2 extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringReuseContext2.class);

    @Autowired
    private TestService2 testService2;

    @Autowired
    private TestServiceA1 testServiceA1;

    @Before
    public void init() {
        logger.info("testService2 hashCode: {}", System.identityHashCode(testService2));
    }

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder();

        testServiceA1.test2(stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }
}
