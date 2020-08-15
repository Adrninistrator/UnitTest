package adrninistrator.test.testmock.spring.suppress.other;

import com.adrninistrator.service.impl.TestServiceB1Impl;
import org.powermock.api.mockito.PowerMockito;

public class TestSpSuppressMethods1 extends TestSpSuppressOtherBase {

    @Override
    protected void doInit() {
        PowerMockito.suppress(PowerMockito.methodsDeclaredIn(TestServiceB1Impl.class));
    }
}
