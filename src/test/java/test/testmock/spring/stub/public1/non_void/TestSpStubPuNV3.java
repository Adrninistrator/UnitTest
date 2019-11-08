package test.testmock.spring.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.Stubber;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.base.TestSpStubBase;

//使用@PrepareForTest指定TestServiceA1Impl.class，stub生效
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPuNV3 extends TestSpStubBase {

    @Test
    public void test1() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toReturn
                (TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        Assert.assertEquals(TestConstants.MOCKED, str);

        str = testServiceB1.test1("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceA1.test1("");
    }

    @Test
    public void test3() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testServiceB1.test1("");
    }

    @Test
    public void test4() {

        Stubber.stubMethod(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1), TestConstants
                .MOCKED);

        String str = testServiceA1.test1("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test5() {

        Stubber.stubMethod(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1, TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
