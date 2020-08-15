package adrninistrator.test.testmock.spring.mock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Mock对象类名标志
public class TestSpMockClassFlag extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpMockClassFlag.class);

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock1;

    @Test
    public void test1() {
        assertEquals(TestPublicNonVoidService1Impl.class, testPublicNonVoidService1.getClass());
        logger.info("className: {}", testPublicNonVoidService1.getClass().getName());
    }

    // Mock对象的类名包含被Mock的标志，如...$MockitoMock$1151489917
    @Test
    public void test2() {
        assertNotEquals(TestPublicNonVoidService1Impl.class, testPublicNonVoidService1Mock1.getClass());
        logger.info("className: {}", testPublicNonVoidService1Mock1.getClass().getName());
    }
}
