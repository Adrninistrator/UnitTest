package adrninistrator.test.testmock.static1.effective.mock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

// Mockito.when()与PowerMockito的stub()、replace()的生效情况
public class TestStEffectiveMockStRe1 extends TestStEffectiveBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG2);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG3);

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());

        // PowerMockito.stub().toReturn()生效
        assertEquals(TestConstants.FLAG2, str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> TestConstants.FLAG3);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test4("");

        // PowerMockito.stub().toReturn()生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
