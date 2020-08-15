package adrninistrator.test.testmock.static1.mock.stub_error;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockSEReturnsDefaults extends TestMockNoSpBase {

    /*
        使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为默认的返回空值的Answer
    */
    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class);

        String result = TestStaticPublicNonVoid2.testString("");
        assertNull(result);

        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING);
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING));
    }

    @Test
    public void test1() {
        // 当执行PowerMockito.mockStatic指定默认Answer为默认的返回空值的Answer时，进行Stub时使用Mockito.when()方法不会执行真实方法
        Mockito.when(TestStaticPublicNonVoid2.testString(Mockito.anyString())).thenReturn(TestConstants.FLAG1);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING));

        String result = TestStaticPublicNonVoid2.testString("");
        assertEquals(TestConstants.FLAG1, result);
    }

    @Test
    public void test2() {
        /*
            使用Mockito.when().then...()对静态公有非void方法进行Stub时，可以分解为以下三步
            执行真实方法，参数使用Stub条件，获取返回值
            针对返回值执行Mockito.when()方法，获得OngoingStubbing对象
            调用OngoingStubbing的then...方法，设置Stub操作

            当执行PowerMockito.mockStatic方法指定默认Answer为默认的返回空值的Answer时，以上执行真实方法的步骤不会执行真实方法
        */
        String str = TestStaticPublicNonVoid2.testString(Mockito.anyString());
        OngoingStubbing ongoingStubbing = Mockito.when(str);
        ongoingStubbing.thenReturn(TestConstants.FLAG2);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING));

        String result = TestStaticPublicNonVoid2.testString("");
        assertEquals(TestConstants.FLAG2, result);
    }

    @Test
    public void test3() throws Exception {
        // 当执行PowerMockito.mockStatic指定默认Answer为默认的返回空值的Answer时，进行Stub时使用PowerMockito.doxxx().when()方法不会执行真实方法
        PowerMockito.doReturn(TestConstants.FLAG3).when(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING,
                Mockito.anyString());

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING));

        String result = TestStaticPublicNonVoid2.testString("");
        assertEquals(TestConstants.FLAG3, result);
    }
}
