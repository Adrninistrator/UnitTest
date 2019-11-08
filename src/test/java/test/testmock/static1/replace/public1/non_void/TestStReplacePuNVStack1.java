package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//获取调用堆栈
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVStack1 extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStReplacePuNVStack1.class);

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> {

                    StackTraceElement stackTraceElement = TestCallTimesUtil.getCallStackElement
                            (TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1);

                    Assert.assertEquals(TestPublicNonVoidService1Impl.class.getName(), stackTraceElement.getClassName
                            ());
                    Assert.assertEquals("testStatic1", stackTraceElement.getMethodName());

                    logger.info("stackTraceElement: {}", stackTraceElement);

                    return TestConstants.MOCKED;
                });

        String str = testPublicNonVoidService1.testStatic1("", null);

        //间接调用，replace生效
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
