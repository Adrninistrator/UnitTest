package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.base.TestMockNoSpBase;

//不使用@PrepareForTest注解指定被Replace方法所在类时，Replace不生效
public class TestStReplacePuNVNoPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with(new TestInvocationHandler1());

        String str = TestStaticPublicNonVoid1.test1("", null);

        //由于没有通过@PrepareForTest指定TestStaticPublicNonVoid1.class，因此PowerMockito.replace不生效
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
