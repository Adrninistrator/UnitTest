package test.testmock.static1.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPuVVerifyCaptor extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVVerifyCaptor.class);

    @Test
    public void test() {

        //创建ArgumentCaptor，对应TestStaticPublicVoid1.test1方法的参数1
        ArgumentCaptor<StringBuffer> argCaptor1 = ArgumentCaptor.forClass(StringBuffer.class);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TestConstants.FLAG1);

        //调用TestStaticPublicVoid1.test1方法
        TestStaticPublicVoid1.test1(stringBuffer);
        logger.info("TestStaticPublicVoid1.test1(): {}", stringBuffer);
        //TestStaticPublicVoid1.test1方法真实方法未执行，因此传入参数未改变
        Assert.assertEquals(TestConstants.FLAG1, stringBuffer.toString());

        //验证TestStaticPublicVoid1.test1方法应调用了一次
        Mockito.verify(TestStaticPublicVoid1.class, Mockito.times(1));
        TestStaticPublicVoid1.test1(argCaptor1.capture());

        //检查TestStaticPublicVoid1.test1方法在调用时的参数与预期是否一致
        logger.info("argCaptor1.getValue(): {}", argCaptor1.getValue());
        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
