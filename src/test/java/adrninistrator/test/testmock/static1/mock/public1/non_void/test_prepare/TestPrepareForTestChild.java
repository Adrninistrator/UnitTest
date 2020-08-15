package adrninistrator.test.testmock.static1.mock.public1.non_void.test_prepare;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// 测试@PrepareForTest注解是否可以在测试类及超类中指定，子类
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestPrepareForTestChild extends TestPrepareForTestParent {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class);
    }

    // @PrepareForTest注解可以在当前类及超类中指定，不会覆盖
    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test3()).thenReturn(TestConstants.MOCKED);

        String result = TestStaticPublicNonVoid1.test3();

        assertEquals(TestConstants.MOCKED, result);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid2.testString(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        String result = TestStaticPublicNonVoid2.testString("");

        assertEquals(TestConstants.MOCKED, result);
    }
}
