package test.testmock.spring.effective.nomock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

import java.io.FileNotFoundException;

//PowerMockito.stub()的toReturn()与toThrow()的生效情况
public class TestSpEffectiveStubThrRe1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3)).toThrow(new
                FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3)).toReturn
                (TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3)).toReturn
                (TestConstants.FLAG2);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3)).toThrow(new
                FileNotFoundException(TestConstants.FLAG2));

        //PowerMockito.stub.toReturn生效
        String str = testServiceA1.test3("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
