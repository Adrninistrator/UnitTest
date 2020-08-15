package adrninistrator.test.testmock.detail;

import com.adrninistrator.common.constants.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

// 获取Mock对象的Stub设置及调用情况
public class TestSpringMockDetailMock2 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailMock2.class);

    private MockingDetails mockingDetails;

    @Before
    public void init() {
        mockingDetails = Mockito.mockingDetails(testServiceA1Mock);

        // 获取设置的Stub设置
        Collection<Stubbing> stubbings = mockingDetails.getStubbings();
        assertEquals(0, stubbings.size());

        Mockito.when(testServiceA1Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
        assertEquals(1, mockingDetails.getStubbings().size());

        Mockito.doAnswer(invocation -> null).when(testServiceA1Mock).test2(Mockito.any(StringBuilder.class));
        assertEquals(2, mockingDetails.getStubbings().size());

        Mockito.when(testServiceA1Mock.test3(Mockito.anyString())).thenThrow(new RuntimeException(TestConstants.MOCKED));
        assertEquals(3, mockingDetails.getStubbings().size());

        printStubbings(mockingDetails.getStubbings());
    }

    @Test
    public void test() {
        // 获取方法调用情况
        Collection<Invocation> invocations = mockingDetails.getInvocations();
        assertEquals(0, invocations.size());

        testServiceA1Mock.test1(TestConstants.FLAG1);
        assertEquals(1, mockingDetails.getInvocations().size());

        testServiceA1Mock.test2(new StringBuilder().append(TestConstants.FLAG2));
        assertEquals(2, mockingDetails.getInvocations().size());

        printInvocations(mockingDetails.getInvocations());

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());
    }
}
