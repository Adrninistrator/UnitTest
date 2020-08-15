package adrninistrator.test.testmock.static1.effective.mock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()与PowerMockito.replace()的生效情况
public class TestStEffectiveMockRe1 extends TestStEffectiveBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test1() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.FLAG2);

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG2);

        // Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.FLAG2, str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test4(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        // Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.when().thenReturn()条件不满足，由于未执行真实方法，PowerMockito.replace().with()不生效，返回值为null
        str = TestStaticPublicNonVoid1.test4("");
        assertNull(str);
    }
}
