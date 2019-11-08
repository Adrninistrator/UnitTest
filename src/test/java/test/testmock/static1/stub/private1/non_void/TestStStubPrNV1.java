package test.testmock.static1.stub.private1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//Stub生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStStubPrNV1 extends TestMockNoSpBase {

    @Before
    public void init() {

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
