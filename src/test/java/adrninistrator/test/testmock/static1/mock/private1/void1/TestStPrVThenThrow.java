package adrninistrator.test.testmock.static1.mock.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestStPrVThenThrow extends TestStaticPrivateVoidBase {

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        // 应出现指定异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        // 指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuilder.class)).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        // 应出现指定异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPrivateVoid1.testPublic1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
