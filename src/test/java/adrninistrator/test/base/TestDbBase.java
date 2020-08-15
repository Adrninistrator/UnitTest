package adrninistrator.test.base;

import adrninistrator.test.common.TestCommonExecutionListener;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

// 数据相关测试基类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
// 需要使Spring Context重新加载，否则获取到的数据源是已关闭的
@DirtiesContext(classMode = BEFORE_CLASS)
@TestExecutionListeners({DirtiesContextBeforeModesTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TestCommonExecutionListener.class})
public abstract class TestDbBase {

    // 以下变量需要保留，在TestCommonExecutionListener中使用
    @Resource(name = "dataSource")
    protected DruidDataSource druidDataSource;
}
