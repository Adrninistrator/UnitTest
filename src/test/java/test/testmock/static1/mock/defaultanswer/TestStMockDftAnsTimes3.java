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
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer执行真实方法
    使用PowerMockito.do...().when()方法对指定方法进行Stub，指定方法的真实方法不会执行
 */
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsTimes3 extends TestStaticPublicNonVoidBase {

    /*
        不能使用@BeforeClass，应使用@Before，使每个@Test方法执行前都执行一次
        否则Mockito.when与PowerMockito.when重复执行会出错
     */
    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new CallsRealMethods());
    }

    @Test
    public void test1() throws Exception {

        String name = "testString";

        int times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(0, times);

        PowerMockito.doReturn(TestConstants.MOCKED).when(TestStaticPublicNonVoid2.class, name, TestConstants.FLAG1);

        times = TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, name);
        Assert.assertEquals(0, times);
    }

    @Test
    public void test2() {

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.doReturn(TestConstants.MOCKED).when(TestStaticPublicNonVoid2.testString(TestConstants.FLAG1));
    }
}