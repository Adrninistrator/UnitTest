package test.testmock.spring.suppress.other;

import com.test.service.impl.TestServiceB1Impl;
import org.powermock.api.mockito.PowerMockito;

public class TestSpSuppressEverything1 extends TestSpSuppressOtherBase {

    @Override
    protected void doInit() {

        PowerMockito.suppress(PowerMockito.everythingDeclaredIn(TestServiceB1Impl.class));
    }
}
