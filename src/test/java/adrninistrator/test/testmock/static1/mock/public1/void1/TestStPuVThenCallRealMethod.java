package adrninistrator.test.testmock.static1.mock.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestStPuVThenCallRealMethod extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVThenCallRealMethod.class);

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1);

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenCallRealMethod();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);

        // 执行TestStaticPublicVoid1.test1
        TestStaticPublicVoid1.test1(stringBuilder);
        // 执行TestStaticPublicVoid1.test1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPublicVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuilder);
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuilder.toString());

        // 真实方法执行了1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
