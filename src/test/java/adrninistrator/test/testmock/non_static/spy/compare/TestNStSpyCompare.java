package adrninistrator.test.testmock.non_static.spy.compare;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.non_static.TestNonStaticWithArg1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Mockito.spy()方法比较
public class TestNStSpyCompare extends TestMockNoSpBase {

    @Test
    public void test1() {
        // 对对象实例执行Mockito.spy
        TestNonStaticNoArg1 testNonStaticNoArg1Spy = Mockito.spy(new TestNonStaticNoArg1());

        // 构造函数已执行
        assertEquals(TestConstants.FLAG1, testNonStaticNoArg1Spy.getFlag());
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestNonStaticNoArg1.class, TestConstants.NAME_CONSTRUCTOR);

        // 对包含无参数构造函数类的class对象执行Mockito.spy
        TestNonStaticNoArg1 testNonStaticNoArg1Spy = Mockito.spy(TestNonStaticNoArg1.class);

        // 无参数构造函数执行了一次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestNonStaticNoArg1.class,
                TestConstants.NAME_CONSTRUCTOR));

        // 构造函数已执行
        assertEquals(TestConstants.FLAG1, testNonStaticNoArg1Spy.getFlag());
    }

    @Test
    public void test3() {
        // 对不包含无参数构造函数类的class对象执行Mockito.spy，会出现异常
        assertThrows(Exception.class, () ->
                Mockito.spy(TestNonStaticWithArg1.class)
        );
    }
}
