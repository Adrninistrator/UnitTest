package test.testmock.spring.stub.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.base.TestSpStubBase;

//Stub公有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPuV1 extends TestSpStubBase {

    @Test
    public void test1() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceA1.test2(null);
    }

    @Test
    public void test2() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceB1.test2(null);
    }
}
