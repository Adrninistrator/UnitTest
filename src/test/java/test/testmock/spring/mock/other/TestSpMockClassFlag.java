package test.testmock.spring.mock.other;

import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Mock对象类名标志
public class TestSpMockClassFlag extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpMockClassFlag.class);

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock1;

    @Test
    public void test1() {

        String className = testPublicNonVoidService1.getClass().getName();
        logger.info("className: {}", className);
        Assert.assertEquals(TestPublicNonVoidService1Impl.class.getName(), className);
    }

    //Mock对象的类名包含被Mock的标志，如...$MockitoMock$1151489917
    @Test
    public void test2() {

        String className = testPublicNonVoidService1Mock1.getClass().getName();
        logger.info("className: {}", className);
        Assert.assertNotEquals(TestPublicNonVoidService1Impl.class.getName(), className);
    }
}
