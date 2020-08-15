package adrninistrator.test.testmock.static1.mock.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPrVVerifyCaptor extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVVerifyCaptor.class);

    @Test
    public void test() throws Exception {

        // 创建ArgumentCaptor，对应TestStaticPrivateVoid1.test1方法的参数1
        ArgumentCaptor<StringBuilder> argCaptor1 = ArgumentCaptor.forClass(StringBuilder.class);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TestConstants.FLAG1);

        // 调用TestStaticPrivateVoid1.test1方法
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuilder);
        logger.info("TestStaticPrivateVoid1.test1(): {}", stringBuilder);
        // TestStaticPrivateVoid1.test1方法真实方法未执行，因此传入参数未改变
        assertEquals(TestConstants.FLAG1, stringBuilder.toString());

        // 验证TestStaticPrivateVoid1.test1方法应调用了一次
        Mockito.verify(TestStaticPrivateVoid1.class, Mockito.times(1));
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, argCaptor1.capture());

        // 检查TestStaticPrivateVoid1.test1方法在调用时的参数与预期是否一致
        logger.info("argCaptor1.getValue(): {}", argCaptor1.getValue());
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }
}
