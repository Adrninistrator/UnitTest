package test.testframework.spring.test;

import com.test.common.TestConstants;
import com.test.service.TestService2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testframework.spring.base.TestSpringBase;

//默认情况下，Spring Context会使用缓存
public class TestSpring1 extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpring1.class);

    @Autowired
    private TestService2 testService2;

    @Before
    public void init() {

        Assert.assertNotNull(testService2);

        logger.info("testService2 hashCode: {}", System.identityHashCode(testService2));
    }

    @Test
    public void test() {

        String str = testService2.test1("");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
