package test.testmock.static1.suppress.method.other;

import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

//对全部方法（含构造函数）进行Suppress
public class TestStSuppressEverything1 extends TestStSuppressOtherBase {

    @Override
    protected void doInit() {

        PowerMockito.suppress(PowerMockito.everythingDeclaredIn(TestStaticPublicNonVoid1.class));
    }
}
