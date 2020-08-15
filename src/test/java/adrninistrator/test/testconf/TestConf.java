package adrninistrator.test.testconf;

import com.adrninistrator.non_static.TestNonStatic2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestConf {

    @Resource(name = "testNonStatic2Bean")
    private TestNonStatic2 testNonStatic2;

    @Test
    public void test() {
        System.out.println("java.class.path: " + System.getProperty("java.class.path"));

        String applicationContextPath = this.getClass().getClassLoader().getResource("applicationContext.xml").getFile();
        System.out.println("applicationContextPath: " + applicationContextPath);

        String testTableMapperPath = this.getClass().getClassLoader().getResource("com/adrninistrator/dao/sqlmap/TestTableMapper.xml").getFile();
        System.out.println("testTableMapperPath: " + testTableMapperPath);

        // test模块的base.properties配置文件生效
        assertEquals("flag_test", testNonStatic2.getFlag());
    }
}
