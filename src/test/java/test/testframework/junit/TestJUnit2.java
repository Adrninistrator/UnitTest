package test.testframework.junit;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

//通过@RunWith指定运行器类为BlockJUnit4ClassRunner，执行正常
@RunWith(BlockJUnit4ClassRunner.class)
public class TestJUnit2 {

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test3();

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
