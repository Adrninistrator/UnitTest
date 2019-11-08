package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//在InvocationHandler中通过method.invoke()执行真实方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVInvoke1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> method.invoke(proxy, args));

        String str = TestStaticPublicNonVoid1.test1("", null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
