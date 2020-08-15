package adrninistrator.test.testmock.static1.mock.public1.void1;

import com.adrninistrator.static1.TestStaticPublicVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
public class TestStPuVVerify extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVVerify.class);

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder();

        // 初始，TestStaticPublicVoid1.test1()执行次数应为0
        Mockito.verify(TestStaticPublicVoid1.class, Mockito.times(0));
        TestStaticPublicVoid1.test1(stringBuilder);

        // 执行TestStaticPublicVoid1.test1方法
        TestStaticPublicVoid1.test1(stringBuilder);
        logger.info("TestStaticPublicVoid1.test1(): {}", stringBuilder);
        // TestStaticPublicVoid1.test1方法真实方法未执行，因此传入参数未改变
        assertEquals("", stringBuilder.toString());

        // TestStaticPublicVoid1.test1()执行次数应变为1
        Mockito.verify(TestStaticPublicVoid1.class, Mockito.times(1));
        TestStaticPublicVoid1.test1(stringBuilder);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
