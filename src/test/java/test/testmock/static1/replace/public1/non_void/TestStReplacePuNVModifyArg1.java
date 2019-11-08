package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//修改调用参数并执行真实方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVModifyArg1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> {

                    //修改参数，并执行真实方法
                    args[0] = TestConstants.FLAG1;

                    return method.invoke(proxy, args);
                });

        String str = TestStaticPublicNonVoid1.test4("");

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);
    }
}
