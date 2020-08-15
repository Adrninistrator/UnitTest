package adrninistrator.test.testmock.spring.async;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestAsyncService1;
import com.adrninistrator.service.impl.TestAsyncService1Impl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotEquals;

// 执行使用@Async注解的方法
public class TestAsyncRun extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestAsyncRun.class);

    @Autowired
    private TestAsyncService1 testAsyncService1;

    @Before
    public void init() {
        // 使用@Async注解时会使用代理，代理对象的Class对象不等于原始类的Class对象
        assertNotEquals(TestAsyncService1Impl.class, testAsyncService1.getClass());
        logger.info("proxy class name: {}", testAsyncService1.getClass().getName());

        if (testAsyncService1.getClass().getName().contains(TestAsyncService1Impl.class.getSimpleName())) {
            // 代理对象类名中包含原始类名，说明使用CGLIB代理
            logger.info("使用CGLIB代理");
        } else {
            // 代理对象类名中不包含原始类名，说明使用JDK动态代理
            logger.info("使用JDK动态代理");
        }
    }

    @Test
    public void test() {
        testAsyncService1.test1("");

        testAsyncService1.async("");
    }
}
