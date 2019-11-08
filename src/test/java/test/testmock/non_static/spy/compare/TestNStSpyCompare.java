package test.testmock.non_static.spy.compare;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStaticNoArg1;
import com.test.non_static.TestNonStaticWithArg1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;

//Mockito.spy()方法比较
public class TestNStSpyCompare extends TestMockNoSpBase {

    @Test
    public void test1() {

        //对对象实例执行Mockito.spy
        TestNonStaticNoArg1 testNonStaticNoArg1Spy = Mockito.spy(new TestNonStaticNoArg1());

        //构造函数已执行
        Assert.assertEquals(TestConstants.FLAG1, testNonStaticNoArg1Spy.getFlag());
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestNonStaticNoArg1.class, TestConstants.NAME_CONSTRUCTOR);

        //对包含无参数构造函数类的class对象执行Mockito.spy
        TestNonStaticNoArg1 testNonStaticNoArg1Spy = Mockito.spy(TestNonStaticNoArg1.class);

        //无参数构造函数执行了一次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestNonStaticNoArg1.class,
                TestConstants.NAME_CONSTRUCTOR));

        //构造函数已执行
        Assert.assertEquals(TestConstants.FLAG1, testNonStaticNoArg1Spy.getFlag());
    }

    @Test
    public void test3() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        //对不包含无参数构造函数类的class对象执行Mockito.spy，会出现异常
        Mockito.spy(TestNonStaticWithArg1.class);
    }
}
