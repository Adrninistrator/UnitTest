package test.testmock.spring.spy.other;

import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Spy对象类名标志
public class TestSpSpyClassFlag extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpSpyClassFlag.class);

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    //Spy对象的类名包含被Mock的标志，如...$MockitoMock$1151489917
    @Test
    public void test() {

        TestPublicNonVoidService1 testPublicNonVoidService1Spy = Mockito.spy(testPublicNonVoidService1);

        String className = testPublicNonVoidService1Spy.getClass().getName();
        logger.info("className: {}", className);
        Assert.assertNotEquals(TestPublicNonVoidService1Impl.class.getName(), className);
    }
}
