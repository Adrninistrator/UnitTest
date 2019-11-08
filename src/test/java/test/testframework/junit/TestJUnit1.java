package test.testframework.junit;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;

//未通过@RunWith指定运行器类，执行正常
public class TestJUnit1 {

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test3();

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
