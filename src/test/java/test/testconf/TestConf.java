package test.testconf;

import com.test.non_static.TestNonStatic2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//使用test目录中的配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestConf {

    @Resource(name = "testNonStatic2Bean")
    private TestNonStatic2 testNonStatic2;

    @Test
    public void test() {

        Assert.assertEquals("flag_test", testNonStatic2.getFlag());
    }
}
