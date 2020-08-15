package adrninistrator.test.testmock.spring.effective.nomock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// PowerMockito.stub().toThrow()与PowerMockito.replace()的生效情况
public class TestSpEffectiveStThrRe1 extends TestSpEffectiveBase {

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // PowerMockito.stub.toThrow在PowerMockito.replace之后，生效
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                testServiceA1.test1("")
        );
        assertEquals(TestConstants.FLAG2, exception.getMessage());
    }

    @Test
    public void test2() {
        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST3))
                .with((proxy, method, args) -> TestConstants.FLAG2);

        String str = testServiceA1.test3("");

        // PowerMockito.replace在PowerMockito.stub.toThrow之后，生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
