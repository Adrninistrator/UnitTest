package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid3;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

// 参数为范型
@PrepareForTest({TestStaticPublicNonVoid3.class})
public class TestStPuNVArgsTemplate extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid3.class, new CallsRealMethods());
    }

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid3.test1(new RuntimeException());
        assertEquals(RuntimeException.class.getSimpleName(), str);

        Mockito.when(TestStaticPublicNonVoid3.test1(Mockito.any(RuntimeException.class))).thenReturn(TestConstants
                .MOCKED);

        str = TestStaticPublicNonVoid3.test1(new RuntimeException());
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test1(new StringBuilder());
        assertEquals(StringBuilder.class.getSimpleName(), str);
    }

    @Test
    public void test2() {
        String str = TestStaticPublicNonVoid3.test2(new RuntimeException());
        assertEquals(RuntimeException.class.getSimpleName(), str);

        Mockito.when(TestStaticPublicNonVoid3.test2(Mockito.any(Exception.class))).thenReturn(TestConstants
                .MOCKED);

        str = TestStaticPublicNonVoid3.test2(new RuntimeException());
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test2(new FileNotFoundException());
        assertEquals(TestConstants.MOCKED, str);
    }
}
