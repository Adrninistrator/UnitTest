package test.testmock.static1.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//执行真实方法
public class TestStPuVThenCallRealMethod extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVThenCallRealMethod.class);

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1);

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenCallRealMethod();

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);

        //执行TestStaticPublicVoid1.test1
        TestStaticPublicVoid1.test1(stringBuffer);
        //执行TestStaticPublicVoid1.test1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPublicVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuffer);
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuffer.toString());

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
