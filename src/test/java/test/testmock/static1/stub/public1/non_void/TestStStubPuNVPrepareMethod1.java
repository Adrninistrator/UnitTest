package test.testmock.static1.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

//在@Test方法级别使用@PrepareForTest注解指定被Stub方法所在类，Stub生效
public class TestStStubPuNVPrepareMethod1 extends TestStStubPuNVBase {

    @PrepareForTest({TestStaticPublicNonVoid1.class})
    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", null);

        //在测试方法上指定@PrepareForTest({TestStaticPublicNonVoid1.class})，PowerMockito.stub生效
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
