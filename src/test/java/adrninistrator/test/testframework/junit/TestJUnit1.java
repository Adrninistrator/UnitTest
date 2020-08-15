package adrninistrator.test.testframework.junit;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 未通过@RunWith指定运行器类，执行正常
public class TestJUnit1 {

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test3();

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
