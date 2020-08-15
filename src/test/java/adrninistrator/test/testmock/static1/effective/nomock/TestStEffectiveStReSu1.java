package adrninistrator.test.testmock.static1.effective.nomock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertNull;

// PowerMockito的stub()、replace()与suppress()的生效情况
public class TestStEffectiveStReSu1 extends TestStEffectiveBase {

    @Test
    public void test1() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG2);

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG3);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.MOCKED);

        // PowerMockito.suppress生效
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertNull(str);
    }
}
