package test.testmock.spring.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

//使用Answer实现回调
public class TestSpMPuNVThenAnswer extends TestMockBase {

    @Test
    public void test() {

        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenAnswer(invocation -> {

            String arg = TestCommonUtil.getMockArg(invocation, 0, String.class);

            Assert.assertEquals(TestConstants.FLAG1, arg);

            return TestConstants.MOCKED;
        });

        String str = testPublicNonVoidService1.test1(TestConstants.FLAG1);

        //满足条件，返回值为被Stub的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
