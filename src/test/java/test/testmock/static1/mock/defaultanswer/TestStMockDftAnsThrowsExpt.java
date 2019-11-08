package test.testmock.static1.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassEquals;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定new ThrowsException()
    对于未被Stub的方法，会抛出指定异常
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsThrowsExpt extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new ThrowsException(new RuntimeException
                (TestConstants.MOCKED)));
    }

    @Test
    public void test() {

        testString();
        testStringBuffer();
        testStringBuilder();
    }

    private void testString() {

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid2.testString("");
    }

    private void testStringBuffer() {

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid2.testStringBuffer("");
    }

    private void testStringBuilder() {

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid2.testStringBuilder("");
    }
}
