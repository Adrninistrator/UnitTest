package adrninistrator.test.testmock.static1.stub.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPrivateVoidService1;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub间接调用生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStStubPrV2 extends TestMockBase {

    @Autowired
    private TestPrivateVoidService1 testPrivateVoidService1;

    @Before
    public void init() {
        testPrivateVoidService1.testStatic1(new StringBuilder());
    }

    @Test
    public void test() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.MOCKED));

        // 应出现指定异常
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                testPrivateVoidService1.testStatic1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
