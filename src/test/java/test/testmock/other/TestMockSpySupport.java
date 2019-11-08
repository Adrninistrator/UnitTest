package test.testmock.other;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStaticNoArg1;
import com.test.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

public class TestMockSpySupport extends TestMockBase {

    private TestNonStaticNoArg1 testNonStaticNoArg1 = new TestNonStaticNoArg1();

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(testNonStaticNoArg1.test1()).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test2() {

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(testPublicNonVoidService1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
    }
}
