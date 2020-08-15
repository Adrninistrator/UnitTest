package adrninistrator.test.testmock.static1.mock.public1.void1;

import com.adrninistrator.static1.TestStaticPublicVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// 什么也不做
public class TestStPuVDoNothing extends TestStaticPublicVoidBase {

    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1);

        PowerMockito.doNothing().when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPublicVoid1.test1(stringBuilder);

        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
