package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//参数为数组
public class TestStPuNVArgsArray extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsArray.class);

    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid1.test8(Mockito.anyString(), Mockito.any(Object[].class))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test8("", new Object[1]);
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test8方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid1.test8(Mockito.anyString(), Mockito.argThat(argument -> TestConstants
                .FLAG1.equals(argument[0])))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test8("", new Object[]{TestConstants.FLAG1});
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test8方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test8("", new Object[1]);
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test8方法，不满足Stub的参数条件，返回null
        Assert.assertNull(str);
    }
}
