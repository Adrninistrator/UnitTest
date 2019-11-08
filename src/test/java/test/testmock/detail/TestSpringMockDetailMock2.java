package test.testmock.detail;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class TestSpringMockDetailMock2 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailMock2.class);

    private MockingDetails mockingDetails;

    @Before
    public void init() {

        Mockito.when(testServiceA1Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        Mockito.doAnswer(invocation -> null).when(testServiceA1Mock).test2(Mockito.any
                (StringBuffer.class));

        Mockito.when(testServiceA1Mock.test3(Mockito.anyString())).thenThrow(new RuntimeException(TestConstants
                .MOCKED));

        mockingDetails = Mockito.mockingDetails(testServiceA1Mock);

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

        testServiceA1Mock.test1(TestConstants.FLAG1);

        invocations = mockingDetails.getInvocations();
        Assert.assertEquals(1, invocations.size());
        printInvocations(invocations);

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());

        testServiceA1Mock.test2(new StringBuffer().append(TestConstants.FLAG2));

        invocations = mockingDetails.getInvocations();
        Assert.assertEquals(2, invocations.size());
        printInvocations(invocations);

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());
    }
}
