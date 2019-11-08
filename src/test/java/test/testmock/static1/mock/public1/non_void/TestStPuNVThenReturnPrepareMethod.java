package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.base.TestMockNoSpBase;

//修改返回值
public class TestStPuNVThenReturnPrepareMethod extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenReturnPrepareMethod.class);

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    //在方法级别使用@PrepareForTest注解
    //对无参数的方法的Stub
    @PrepareForTest({TestStaticPublicNonVoid1.class})
    @Test
    public void test() {

        Mockito.when(TestStaticPublicNonVoid1.test3()).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test3();
        logger.info("TestStaticPublicNonVoid1.test3() thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test3方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
