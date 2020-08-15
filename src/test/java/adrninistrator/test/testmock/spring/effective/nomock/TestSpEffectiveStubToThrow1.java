package adrninistrator.test.testmock.spring.effective.nomock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// PowerMockito.stub().toThrow()执行多次的生效情况
public class TestSpEffectiveStubToThrow1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // 最后一次PowerMockito.stub生效
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                testServiceA1.test1("")
        );
        assertEquals(TestConstants.FLAG2, exception.getMessage());
    }
}
