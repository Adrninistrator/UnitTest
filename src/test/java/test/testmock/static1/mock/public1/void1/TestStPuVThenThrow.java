package test.testmock.static1.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassEquals;

//抛出异常
public class TestStPuVThenThrow extends TestStaticPublicVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicVoid1.test1(new StringBuffer());
    }
}
