package test.testmock.spring.stub.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.base.TestSpStubBase;

//Stub私有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPrNV1 extends TestSpStubBase {

    @Test
    public void test1() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toReturn
                (TestConstants.MOCKED);

        String str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "");

        Assert.assertEquals(TestConstants.MOCKED, str);

        str = testServiceA1.test3("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "");
    }

    @Test
    public void test3() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceA1.test3("");
    }
}
