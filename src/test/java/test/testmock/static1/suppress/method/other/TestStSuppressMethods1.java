package test.testmock.static1.suppress.method.other;

import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

//对全部方法（不含构造函数）进行Suppress
public class TestStSuppressMethods1 extends TestStSuppressOtherBase {

    @Override
    protected void doInit() {

        PowerMockito.suppress(PowerMockito.methodsDeclaredIn(TestStaticPublicNonVoid1.class));
    }
}
