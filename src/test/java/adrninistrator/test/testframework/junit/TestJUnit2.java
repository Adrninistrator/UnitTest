package adrninistrator.test.testframework.junit;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

// 通过@RunWith指定运行器类为BlockJUnit4ClassRunner，执行正常
@RunWith(BlockJUnit4ClassRunner.class)
public class TestJUnit2 {

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test3();

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
