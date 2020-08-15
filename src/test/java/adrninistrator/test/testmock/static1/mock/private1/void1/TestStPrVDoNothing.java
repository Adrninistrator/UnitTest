package adrninistrator.test.testmock.static1.mock.private1.void1;

import com.adrninistrator.static1.TestStaticPrivateVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 什么也不做
public class TestStPrVDoNothing extends TestStaticPrivateVoidBase {

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        PowerMockito.doNothing().when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuilder);

        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        // 指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuilder.class)).thenCallRealMethod();
        PowerMockito.doNothing().when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPrivateVoid1.testPublic1(stringBuilder);

        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }
}
