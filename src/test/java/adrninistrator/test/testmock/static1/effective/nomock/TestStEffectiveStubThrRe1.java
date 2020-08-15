package adrninistrator.test.testmock.static1.effective.nomock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

// PowerMockito.stub()的toReturn()与toThrow()的生效情况
public class TestStEffectiveStubThrRe1 extends TestStEffectiveBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG2);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // PowerMockito.stub().toReturn()生效
        String str = TestStaticPublicNonVoid1.test4("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
