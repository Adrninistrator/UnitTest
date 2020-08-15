package adrninistrator.test.testmock.base;

import adrninistrator.test.common.TestCommonExecutionListener;
import com.adrninistrator.applicationlistener.TestApplicationListener;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*", "javax.crypto.*", "javax.security.*", "javax.script.*"})
@TestExecutionListeners({DirtiesContextBeforeModesTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TestCommonExecutionListener.class})
public abstract class TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMockBase.class);

    @Autowired
    protected TestApplicationListener testApplicationListener;

    // 以下变量需要保留，在TestCommonExecutionListener中使用
    @Resource(name = "dataSource")
    protected DruidDataSource druidDataSource;

    @Before
    public void beforeTestMockBase() {
        logger.info("### Spring refresh event hashCode: {}", testApplicationListener.getRefreshEventHashCode());
    }
}
