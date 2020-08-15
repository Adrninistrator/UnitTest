package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 参数为数组
public class TestStPuNVArgsArray extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsArray.class);

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test8(Mockito.anyString(), Mockito.any(Object[].class))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test8("", new Object[1]);
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test8方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test8(Mockito.anyString(), Mockito.argThat(argument -> TestConstants
                .FLAG1.equals(argument[0])))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test8("", new Object[]{TestConstants.FLAG1});
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test8方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test8("", new Object[1]);
        logger.info("TestStaticPublicNonVoid1.test8(\"\", new Object[1]) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test8方法，不满足Stub的参数条件，返回null
        assertNull(str);
    }
}
