package test.testmock.static1.effective.nomock;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.static1.effective.base.TestStEffectiveBase;

import java.io.FileNotFoundException;

//PowerMockito.stub()的toReturn()与toThrow()的生效情况
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

        //PowerMockito.stub().toReturn()生效
        String str = TestStaticPublicNonVoid1.test4("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
