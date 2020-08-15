package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

public abstract class TestNStMConstructorNoArgBase extends TestMockBase {

    @Before
    public void initTestNStMConstructorNoArgBase() throws Exception {

        TestNonStaticNoArg1 testNonStaticNoArg1Mock = Mockito.mock(TestNonStaticNoArg1.class);
        Mockito.when(testNonStaticNoArg1Mock.test1()).thenReturn(TestConstants.MOCKED);

        PowerMockito.whenNew(TestNonStaticNoArg1.class).withNoArguments().thenReturn(testNonStaticNoArg1Mock);
    }
}
