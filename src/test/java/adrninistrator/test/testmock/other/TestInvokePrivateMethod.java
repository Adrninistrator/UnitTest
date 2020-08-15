package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPrivateNonVoidService1;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 执行私有方法
public class TestInvokePrivateMethod extends TestMockBase {

    @Autowired
    private TestPrivateNonVoidService1 testPrivateNonVoidService1;

    // 执行静态私有方法
    @Test
    public void test1() throws Exception {

        String str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST3);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    // 执行非静态私有方法
    @Test
    public void test2() throws Exception {

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    // 通过PowerMockito.method().invoke()执行私有方法
    @Test
    public void test3() throws Exception {

        String str = (String) PowerMockito.method(TestPrivateNonVoidService1Impl.class, TestPrivateNonVoidService1Impl
                .NAME_TEST1).invoke(testPrivateNonVoidService1, "");

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
