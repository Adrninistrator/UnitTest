package test.testmock.static1.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import test.testmock.base.TestMockNoSpBase;

public abstract class TestStStubPuNVBase extends TestMockNoSpBase {

    @Before
    public void initTestStStubPuNVBase() {

        String str = TestStaticPublicNonVoid1.test1("", null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
