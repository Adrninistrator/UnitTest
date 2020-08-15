package adrninistrator.test.testmock.detail;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import org.mockito.Mock;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public abstract class TestSpringMockDetailBase extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailBase.class);

    @Mock
    protected TestServiceA1 testServiceA1Mock;

    protected void printStubbings(Collection<Stubbing> stubbings) {
        for (Stubbing stubbing : stubbings) {
            logger.info("stubbing: \r\n{}", stubbing);
        }
    }

    protected void printInvocations(Collection<Invocation> invocations) {
        for (Invocation invocation : invocations) {
            logger.info("invocation: \r\n{}", invocation);
        }
    }
}
