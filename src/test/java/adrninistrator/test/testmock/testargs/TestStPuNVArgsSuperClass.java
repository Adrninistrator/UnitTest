package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()的Stub参数条件使用超类或子类
public class TestStPuNVArgsSuperClass extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test10(Mockito.anyString(), Mockito.any(Exception.class))).thenReturn
                (TestConstants.MOCKED);

        // Stub条件为等于超类，参数为超类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test10("", new Exception()));

        // Stub条件为等于超类，参数为子类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test10("", new RuntimeException()));
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test10(Mockito.anyString(), Mockito.any(RuntimeException.class))).thenReturn
                (TestConstants.MOCKED);

        // Stub条件为等于子类，参数为子类时Stub生效
        assertEquals(TestConstants.MOCKED, TestStaticPublicNonVoid1.test10("", new RuntimeException()));

        // Stub条件为等于子类，参数为超类时Stub不生效
        assertNull(TestStaticPublicNonVoid1.test10("", new Exception()));
    }
}
