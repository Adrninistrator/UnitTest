package test.testmock.spring.stub.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.base.TestSpStubBase;

//Stub私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPrV1 extends TestSpStubBase {

    @Test
    public void test1() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, null);
    }

    @Test
    public void test2() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceA1.test4(null);
    }
}
