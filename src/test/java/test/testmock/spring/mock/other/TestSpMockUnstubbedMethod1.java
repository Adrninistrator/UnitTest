package test.testmock.spring.mock.other;

import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import test.testmock.base.TestMockBase;

//未Stub的方法的返回值
public class TestSpMockUnstubbedMethod1 extends TestMockBase {

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock;

    //测试Mockito.mock返回的对象
    @Test
    public void test1() {

        doTest(Mockito.mock(TestPublicNonVoidService1.class));
    }

    //测试@Mock注解产生的对象
    @Test
    public void test2() {

        doTest(testPublicNonVoidService1Mock);
    }

    private void doTest(TestPublicNonVoidService1 testPublicNonVoidService1) {

        String str = testPublicNonVoidService1.test3("");
        //未Stub的方法，返回值为null
        Assert.assertNull(str);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
