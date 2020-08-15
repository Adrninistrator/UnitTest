package adrninistrator.test.testmock.detail;

import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

// 获取Mock类型及默认Answer等详细信息
public class TestSpringMockDetailSpy1 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailSpy1.class);

    @Autowired
    private TestServiceA1 testServiceA1;

    private TestServiceA1 testServiceA1Spy;

    private MockingDetails mockingDetails;

    private MockCreationSettings mockCreationSettings;

    @Before
    public void init() {
        testServiceA1Spy = Mockito.spy(testServiceA1);

        mockingDetails = Mockito.mockingDetails(testServiceA1Spy);

        mockCreationSettings = mockingDetails.getMockCreationSettings();
    }

    @Test
    public void test() {
        // 获取被Mock的类型
        Class mockClass = mockCreationSettings.getTypeToMock();

        assertEquals(TestServiceA1Impl.class, mockClass);
        logger.info("mockCreationSettings.getTypeToMock(): {}", mockClass);

        // 获取默认Answer
        Answer defaultAnswer = mockCreationSettings.getDefaultAnswer();

        assertSame(Mockito.CALLS_REAL_METHODS, defaultAnswer);
        logger.info("mockCreationSettings.getDefaultAnswer(): {}", defaultAnswer);
    }
}
