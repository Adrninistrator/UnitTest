package test.testmock.static1.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid2;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为执行真实方法
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public abstract class TestStMockDftAnsCallsRealMethodsBase extends TestStaticPublicNonVoidBase {

    @Test
    public void test() throws Exception {

        testString();
        testStringBuffer();
        testStringBuilder();
        testByteLower();
    }

    private void testString() {

        String str = TestStaticPublicNonVoid2.testString("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    private void testStringBuffer() {

        StringBuffer stringBuffer = TestStaticPublicNonVoid2.testStringBuffer("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());
    }

    private void testStringBuilder() {

        StringBuilder stringBuilder = TestStaticPublicNonVoid2.testStringBuilder("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }

    private void testByteLower() {

        Mockito.when(TestStaticPublicNonVoid2.testByteLower(Mockito.anyString())).thenReturn((byte) 1);
        byte byte1 = TestStaticPublicNonVoid2.testByteLower("");
        Assert.assertEquals(1, byte1);
    }
}
