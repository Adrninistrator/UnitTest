package test.testmock.spring.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//执行真实方法
public class TestSpMPuNVThenCallRealMethod extends TestMockBase {

    //对于接口的Mock对象，不支持Mockito.when().thenCallRealMethod()
    @Test
    public void test1() {

        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenCallRealMethod();
    }

    //对于实现类，支持Mockito.when().thenCallRealMethod()
    @Test
    public void test2() {

        TestPublicNonVoidService1Impl testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenCallRealMethod();

        String str = testPublicNonVoidService1.test1(TestConstants.FLAG1);
        //满足Stub条件，返回数据应为原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //Mockito.when执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1.test1("");
        //不满足Stub条件，返回值为null
        Assert.assertNull(str);

        //真实方法已执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test3() {

        TestPublicNonVoidService1Impl testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class);

        Mockito.when(testPublicNonVoidService1.test2(Mockito.anyString())).thenCallRealMethod();

        //执行真实方法，由于testTableMapper对象为空，会出现空指针异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        testPublicNonVoidService1.test2("");
    }
}
