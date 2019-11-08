package test.testmock.static1.mock.public1.void1;

import com.test.static1.TestStaticPublicVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

//什么也不做
public class TestStPuVDoNothing extends TestStaticPublicVoidBase {

    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1);

        PowerMockito.doNothing().when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        TestStaticPublicVoid1.test1(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());

        //未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
