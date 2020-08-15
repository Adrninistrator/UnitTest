package adrninistrator.test.testmock.static1.stub.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub间接调用生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStStubPuV2 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Before
    public void init() {
        testPublicVoidService1.test1(new StringBuilder());
    }

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).toThrow(
                (new FileNotFoundException(TestConstants.MOCKED)));

        // 应出现指定异常
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                testPublicVoidService1.testStatic1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
