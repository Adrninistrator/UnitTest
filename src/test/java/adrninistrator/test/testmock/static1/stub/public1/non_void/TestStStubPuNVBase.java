package adrninistrator.test.testmock.static1.stub.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public abstract class TestStStubPuNVBase extends TestMockNoSpBase {

    @Before
    public void initTestStStubPuNVBase() {
        String str = TestStaticPublicNonVoid1.test1("", null);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
