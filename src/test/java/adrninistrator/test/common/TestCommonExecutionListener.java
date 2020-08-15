package adrninistrator.test.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestCommonExecutionListener extends AbstractTestExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(TestCommonExecutionListener.class);

    // 记录当前执行的测试类总的@Test方法数量
    private AtomicInteger testMethodsNum = new AtomicInteger(0);

    // 记录当前执行的测试类已执行完毕的@Test方法次数
    private AtomicInteger runAfterTimes = new AtomicInteger(0);

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {

        // beforeTestClass()方法执行时，TestContext中的testClass非null，testMethod、testInstance为null
        assertNotNull(testContext.getTestClass());
        assertNull(testContext.getTestMethod());
        assertNull(testContext.getTestInstance());

        // 获取Mockito与PowerMock版本
        TestCommonUtil.isMockitoNew();
        TestCommonUtil.isPowerMockNew();
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        logger.info("prepareTestInstance TestExecutionListener [{}] hashCode {}", testContext.getTestClass().getSimpleName(),
                System.identityHashCode(this));

        // prepareTestInstance()方法执行时，TestContext中的testMethod为null，testClass、testInstance非null，且测试对象已完成依赖注入
        assertNull(testContext.getTestMethod());
        assertNotNull(testContext.getTestInstance());
        assertNotNull(Whitebox.getInternalState(testContext.getTestInstance(), DruidDataSource.class));
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        // 获取当前测试类类型
        Class testClass = testContext.getTestClass();

        logger.info("### beforeTestMethod [{}.{}()]", testClass.getSimpleName(), testContext.getTestMethod().getName());

        // 记录当前测试类@Test方法数量
        recordTestMethodsNum(testClass);

        // 执行自定义注解指定的初始化操作
        runInitMethod(testClass);
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (runAfterTimes.addAndGet(1) == testMethodsNum.get()) {
            // 当前测试类所有的@Test方法执行完毕时，关闭数据源

            // 获取当前测试类实例中的DruidDataSource对象
            DruidDataSource druidDataSource = Whitebox.getInternalState(testContext.getTestInstance(), DruidDataSource.class);

            if (druidDataSource != null) {
                logger.info("*** afterTestMethod [{}.{}()] druidDataSource.close", testContext.getTestClass().getSimpleName(),
                        testContext.getTestMethod().getName());

                druidDataSource.close();
            }
        }
    }

    // 记录@Test方法数量
    private void recordTestMethodsNum(Class testClass) {
        // 若@Test方法数量已大于0，说明已记录，退出
        if (testMethodsNum.get() > 0) {
            return;
        }

        // 获取当前类的方法中包含@Test的方法数量
        testMethodsNum.compareAndSet(0, TestCommonUtil.getTestNum(testClass));

        logger.info("@Test runTimes [{}] {}", testClass.getSimpleName(), testMethodsNum.get());
    }

    // 执行自定义注解指定的初始化操作
    private void runInitMethod(Class testClass) {
        TestInitAnnotation testInitAnnotation = AnnotationUtils.findAnnotation(testClass, TestInitAnnotation.class);
        if (testInitAnnotation == null) {
            return;
        }

        // 当前测试类存在自定义注解时，继续处理
        try {
            Class<? extends TestInitInterface>[] testInitClasses = testInitAnnotation.value();
            for (Class<? extends TestInitInterface> testInitClazz : testInitClasses) {
                TestInitInterface testInitClass = testInitClazz.newInstance();

                logger.info("执行自定义注解指定的初始化操作: [{}] {}", testClass.getSimpleName(), testInitClazz);
                testInitClass.init();
            }
        } catch (Exception e) {
            logger.error("执行自定义注解指定的初始化操作错误 [{}] ", testClass.getSimpleName(), e);
        }
    }
}
