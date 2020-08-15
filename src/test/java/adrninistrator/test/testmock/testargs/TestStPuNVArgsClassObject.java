package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()的Stub参数条件使用Class对象
public class TestStPuNVArgsClassObject extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test11("", Exception.class)).thenReturn(TestConstants.MOCKED);
        doTestSuperClass();
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test11("", RuntimeException.class)).thenReturn(TestConstants.MOCKED);
        doTestChildClass();
    }

    @Test
    public void test3() {
        Mockito.when(TestStaticPublicNonVoid1.test11(Mockito.anyString(), Mockito.eq(Exception.class))).thenReturn(TestConstants.MOCKED);
        doTestSuperClass();
    }

    @Test
    public void test4() {
        Mockito.when(TestStaticPublicNonVoid1.test11(Mockito.anyString(), Mockito.eq(RuntimeException.class))).thenReturn(TestConstants.MOCKED);
        doTestChildClass();
    }

    @Test
    public void test5() {
        Mockito.when(TestStaticPublicNonVoid1.test11(Mockito.anyString(), Mockito.argThat(argument -> Exception.class.isAssignableFrom(argument))))
                .thenReturn(TestConstants.MOCKED);

        // Stub条件为等于超类，参数为超类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test11("", Exception.class));

        // Stub条件为等于超类，参数为子类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test11("", RuntimeException.class));
    }

    @Test
    public void test6() {
        Mockito.when(TestStaticPublicNonVoid1.test11(Mockito.anyString(), Mockito.argThat(argument -> RuntimeException.class.isAssignableFrom
                (argument)))).thenReturn(TestConstants.MOCKED);
        doTestChildClass();
    }

    private void doTestSuperClass() {
        // Stub条件为等于超类，参数为超类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test11("", Exception.class));

        // Stub条件为等于超类，参数为子类时Stub不生效
        assertNull(TestStaticPublicNonVoid1.test11("", RuntimeException.class));
    }

    private void doTestChildClass() {
        // Stub条件为等于子类，参数为子类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test11("", RuntimeException.class));

        // Stub条件为等于子类，参数为超类时Stub不生效
        assertNull(TestStaticPublicNonVoid1.test11("", Exception.class));
    }
}
