package test.testmock.static1.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//修改返回值，对于没有参数的方法的Stub
public class TestStPrNVThenReturn2 extends TestStaticPrivateNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrNVThenReturn2.class);

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST3).thenReturn
                (TestConstants.MOCKED);

        String str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST3);
        logger.info("TestStaticPrivateNonVoid1.test3() thenReturn: {}", str);
        //执行TestStaticPrivateNonVoid1.test3方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        //指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic3()).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST3).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPrivateNonVoid1.testPublic3();
        logger.info("TestStaticPrivateNonVoid1.testPublic3() thenReturn: {}", str);
        //执行TestStaticPrivateNonVoid1.testPublic3方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
