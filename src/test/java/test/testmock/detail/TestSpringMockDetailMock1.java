package test.testmock.detail;

import com.test.service.TestServiceA1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

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

        Class mockClass = mockCreationSettings.getTypeToMock();

        Assert.assertEquals(TestServiceA1.class, mockClass);
        logger.info("mockCreationSettings.getTypeToMock(): {}", mockClass);

        Answer defaultAnswer = mockCreationSettings.getDefaultAnswer();

        Assert.assertEquals(Mockito.RETURNS_DEFAULTS, defaultAnswer);
        logger.info("mockCreationSettings.getDefaultAnswer(): {}", defaultAnswer);
    }

    @Test
    public void test2() {

        Collection<Invocation> invocations = mockingDetails.getInvocations();

        Assert.assertEquals(0, invocations.size());

        Collection<Stubbing> stubbings = mockingDetails.getStubbings();

        Assert.assertEquals(0, stubbings.size());

        logger.info("printInvocations: \r\n{}", mockingDetails.printInvocations());
    }
}
