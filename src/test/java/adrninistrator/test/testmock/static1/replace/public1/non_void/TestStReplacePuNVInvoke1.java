package adrninistrator.test.testmock.static1.replace.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// 在InvocationHandler中通过method.invoke()执行真实方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVInvoke1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> method.invoke(proxy, args));

        String str = TestStaticPublicNonVoid1.test1("", null);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
