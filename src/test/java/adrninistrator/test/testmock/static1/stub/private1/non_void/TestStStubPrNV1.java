package adrninistrator.test.testmock.static1.stub.private1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Stub生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStStubPrNV1 extends TestMockNoSpBase {

    @Before
    public void init() {
        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        assertEquals(TestConstants.MOCKED, str);
    }
}
