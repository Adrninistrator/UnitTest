package test.testmock.detail;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class TestSpringMockDetailSpy2 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailSpy2.class);

    @Autowired
    private TestServiceA1 testServiceA1;

    private TestServiceA1 testServiceA1Spy;

    private MockingDetails mockingDetails;

    @Before
    public void init() {

        testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        Mockito.doAnswer(invocation -> null).when(testServiceA1Spy).test2(Mockito.any
                (StringBuffer.class));

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testServiceA1Spy).test3(Mockito.anyString());

        mockingDetails = Mockito.mockingDetails(testServiceA1Spy);

        Collection<Stubbing> stubbings = mockingDetails.getStubbings();
        Assert.assertEquals(3, stubbings.size());
        printStubbings(stubbings);
    }

    @Test
    public void test() {

        Collection<Invocation> invocations = mockingDetails.getInvocations();
        Assert.assertEquals(0, invocations.size());
        printInvocations(invocations);

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());

        testServiceA1Spy.test1(TestConstants.FLAG1);

        invocations = mockingDetails.getInvocations();
        Assert.assertEquals(1, invocations.size());
        printInvocations(invocations);

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());

        testServiceA1Spy.test2(new StringBuffer().append(TestConstants.FLAG2));

        invocations = mockingDetails.getInvocations();
        Assert.assertEquals(2, invocations.size());
        printInvocations(invocations);

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());
    }
}
