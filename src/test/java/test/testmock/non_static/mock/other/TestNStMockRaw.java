package test.testmock.non_static.mock.other;

import com.test.non_static.TestNonStatic1;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;

//对原始对象进行Stub
public class TestNStMockRaw extends TestMockNoSpBase {

    @Test
    public void test() {

        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(testNonStatic1.test1()).thenReturn(null);
    }
}
