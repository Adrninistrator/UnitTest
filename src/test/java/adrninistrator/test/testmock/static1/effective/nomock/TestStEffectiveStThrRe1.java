package adrninistrator.test.testmock.static1.effective.nomock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// PowerMockito.stub().toThrow()与PowerMockito.replace()的生效情况
public class TestStEffectiveStThrRe1 extends TestStEffectiveBase {

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // PowerMockito.stub.toThrow在PowerMockito.replace之后，生效
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                TestStaticPublicNonVoid1.test1("", new TestTableEntity())
        );
        assertEquals(TestConstants.FLAG2, exception.getMessage());
    }

    @Test
    public void test2() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> TestConstants.FLAG2);

        // PowerMockito.replace在PowerMockito.stub.toThrow之后，生效
        String str = TestStaticPublicNonVoid1.test4("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
