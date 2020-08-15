package adrninistrator.test.testmock.detail;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

// 获取Mock对象的Stub设置及调用情况
public class TestSpringMockDetailSpy2 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailSpy2.class);

    @Spy
    @Autowired
    private TestServiceA1 testServiceA1Spy;

    private MockingDetails mockingDetails;

    @Before
    public void init() {
        mockingDetails = Mockito.mockingDetails(testServiceA1Spy);

        // 获取设置的Stub设置
        Collection<Stubbing> stubbings = mockingDetails.getStubbings();
        assertEquals(0, stubbings.size());

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());
        assertEquals(1, mockingDetails.getStubbings().size());

        Mockito.doAnswer(invocation -> null).when(testServiceA1Spy).test2(Mockito.any(StringBuilder.class));
        assertEquals(2, mockingDetails.getStubbings().size());

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testServiceA1Spy).test3(Mockito.anyString());
        assertEquals(3, mockingDetails.getStubbings().size());

        printStubbings(mockingDetails.getStubbings());
    }

    @Test
    public void test() {
        // 获取方法调用情况
        Collection<Invocation> invocations = mockingDetails.getInvocations();
        assertEquals(0, invocations.size());

        testServiceA1Spy.test1(TestConstants.FLAG1);
        assertEquals(1, mockingDetails.getInvocations().size());

        testServiceA1Spy.test2(new StringBuilder().append(TestConstants.FLAG2));
        assertEquals(2, mockingDetails.getInvocations().size());

        printInvocations(mockingDetails.getInvocations());

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());
    }
}
