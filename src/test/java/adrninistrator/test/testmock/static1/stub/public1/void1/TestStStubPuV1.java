package adrninistrator.test.testmock.static1.stub.public1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStStubPuV1 extends TestMockNoSpBase {

    @Before
    public void init() {
        TestStaticPublicVoid1.test1(new StringBuilder());
    }

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).toThrow(
                (new FileNotFoundException(TestConstants.MOCKED)));

        // 应出现指定异常
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                TestStaticPublicVoid1.test1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
