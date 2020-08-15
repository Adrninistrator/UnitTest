package adrninistrator.test.testmock.static1.stub.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 间接调用被Stub方法，Stub生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStStubPuNVIndirect1 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        String str = testPublicNonVoidService1.testStatic1("", null);

        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {
        // PowerMockito.method可以指定方法参数
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1)).toReturn(TestConstants.MOCKED);

        String str = testPublicNonVoidService1.testStatic1("", null);

        // 间接调用，Stub生效
        assertEquals(TestConstants.MOCKED, str);
    }
}
