package test.testmock.static1.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid2;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer执行真实方法
    使用Mockito.when().then...()方法对指定方法进行Stub，指定方法的真实方法会执行
 */
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsTimes2 extends TestStaticPublicNonVoidBase {

    /*
        不能使用@BeforeClass，应使用@Before，使每个@Test方法执行前都执行一次
        否则Mockito.when与PowerMockito.when重复执行会出错
     */
    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new CallsRealMethods());
    }

    @Test
    public void test1() {

        String name = "testString";

        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid2.class, name);

        int times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(0, times);

        Mockito.when(TestStaticPublicNonVoid2.testString(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(1, times);
    }

    //PowerMockito.when也支持
    @Test
    public void test2() {

        String name = "testString";

        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid2.class, name);

        int times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(0, times);

        PowerMockito.when(TestStaticPublicNonVoid2.testString(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(1, times);
    }
}
