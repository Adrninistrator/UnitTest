package adrninistrator.test.testmock.static1.stub.private1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPrivateNonVoidService1;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Stub间接调用生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStStubPrNV2 extends TestMockBase {

    @Autowired
    private TestPrivateNonVoidService1 testPrivateNonVoidService1;

    @Before
    public void init() {
        String str = testPrivateNonVoidService1.testStatic1("", null);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = testPrivateNonVoidService1.testStatic1("", null);

        assertEquals(TestConstants.MOCKED, str);
    }
}
