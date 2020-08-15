package adrninistrator.test.testmock.detail;

import com.adrninistrator.service.TestServiceA1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

// 获取Mock类型及默认Answer等详细信息
public class TestSpringMockDetailMock1 extends TestSpringMockDetailBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringMockDetailMock1.class);

    private MockingDetails mockingDetails;

    private MockCreationSettings mockCreationSettings;

    @Before
    public void init() {
        mockingDetails = Mockito.mockingDetails(testServiceA1Mock);

        mockCreationSettings = mockingDetails.getMockCreationSettings();
    }

    @Test
    public void test1() {
        // 获取被Mock的类型
        assertEquals(RuntimeException.class,
                Mockito.mockingDetails(Mockito.mock(RuntimeException.class)).getMockCreationSettings().getTypeToMock());

        // 获取默认Answer
        assertSame(Mockito.RETURNS_DEFAULTS,
                Mockito.mockingDetails(Mockito.mock(RuntimeException.class)).getMockCreationSettings().getDefaultAnswer());
    }

    @Test
    public void test2() {
        // 获取被Mock的类型
        Class mockClass = mockCreationSettings.getTypeToMock();

        assertEquals(TestServiceA1.class, mockClass);
        logger.info("mockCreationSettings.getTypeToMock(): {}", mockClass);

        // 获取默认Answer
        Answer defaultAnswer = mockCreationSettings.getDefaultAnswer();

        assertSame(Mockito.RETURNS_DEFAULTS, defaultAnswer);
        logger.info("mockCreationSettings.getDefaultAnswer(): {}", defaultAnswer);
    }
}
