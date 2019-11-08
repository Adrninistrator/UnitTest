package test.testmock.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.applicationlistener.TestApplicationListener;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.common.TestCommonUtil;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*", "javax.crypto.*"})
public abstract class TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMockBase.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private TestApplicationListener testApplicationListener;

    @Resource(name = "dataSource")
    private DruidDataSource druidDataSource;

    private static int totalRunTimes = 0;

    private static AtomicInteger runTimes = new AtomicInteger(0);

    @BeforeClass
    public static void beforeClassTestMockBase() {

        //提前获取Mockito与PowerMock版本
        TestCommonUtil.isMockitoNew();
        TestCommonUtil.isPowerMockNewest();
    }

    @Before
    public void initTestMockBase() {

        addRunTimes();

        logger.info("### start {}", this.getClass().getName());
        logger.info("### Spring refresh event hashCode: {}", testApplicationListener.getRefreshEventHashCode());
    }

    @After
    public void afterTestMockBase() {

        if (runTimes.addAndGet(1) == totalRunTimes) {

            logger.info("*** {} afterTestMockBase druidDataSource.close", this.getClass().getName());

            druidDataSource.close();
        }
    }

    private void addRunTimes() {

        if (totalRunTimes > 0) {
            return;
        }

        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {

            Test testAnnotation = AnnotationUtils.findAnnotation(method, Test.class);
            if (testAnnotation != null) {
                totalRunTimes++;
            }
        }

        logger.info("@Test runTimes: {}", totalRunTimes);
    }
}
