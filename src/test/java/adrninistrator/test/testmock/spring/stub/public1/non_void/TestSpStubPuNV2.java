package adrninistrator.test.testmock.spring.stub.public1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// 使用@PrepareForTest指定TestServiceA1.class，stub不生效
@PrepareForTest({TestServiceA1.class})
public class TestSpStubPuNV2 extends TestSpStubBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toReturn
                (TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
