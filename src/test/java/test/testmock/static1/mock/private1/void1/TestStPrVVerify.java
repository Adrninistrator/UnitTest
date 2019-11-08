package test.testmock.static1.mock.private1.void1;

import com.test.static1.TestStaticPrivateVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//使用verify判断方法的执行次数
public class TestStPrVVerify extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVVerify.class);

    @Test
    public void test() throws Exception {

        StringBuffer stringBuffer = new StringBuffer();

        //初始，TestStaticPrivateVoid1.test1()执行次数应为0
        Mockito.verify(TestStaticPrivateVoid1.class, Mockito.times(0));
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);

        //执行TestStaticPrivateVoid1.test1方法
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);
        logger.info("TestStaticPrivateVoid1.test1(): {}", stringBuffer);
        //TestStaticPrivateVoid1.test1方法真实方法未执行，因此传入参数未改变
        Assert.assertEquals("", stringBuffer.toString());

        //TestStaticPrivateVoid1.test1()执行次数应变为1
        Mockito.verify(TestStaticPrivateVoid1.class, Mockito.times(1));
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }
}
