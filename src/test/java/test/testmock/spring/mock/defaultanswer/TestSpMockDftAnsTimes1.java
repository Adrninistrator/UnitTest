package test.testmock.spring.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import test.testmock.base.TestMockBase;

public class TestSpMockDftAnsTimes1 extends TestMockBase {

    private TestPublicNonVoidService1Impl testPublicNonVoidService1;

    @Before
    public void init() {

        /*
            对实现类执行Mockito.mock
            通过Mockito.withSettings().defaultAnswer指定CallsRealMethods
            未Stub的方法会执行真实方法
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class, Mockito.withSettings()
                .defaultAnswer(new CallsRealMethods()));
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1).test1(Mockito.anyString());

        //Mockito.doReturn未执行真实方法
        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(0, times);
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        Mockito.when(testPublicNonVoidService1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        //Mockito.when().thenReturn()执行1次真实方法
        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(1, times);
    }
}
