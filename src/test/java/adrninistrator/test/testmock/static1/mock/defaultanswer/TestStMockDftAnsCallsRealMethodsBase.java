package adrninistrator.test.testmock.static1.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为执行真实方法
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public abstract class TestStMockDftAnsCallsRealMethodsBase extends TestMockNoSpBase {

    @Test
    public void testBase() {

        testString();
        testStringBuffer();
        testStringBuilder();
        testByteLower();
    }

    private void testString() {
        String str = TestStaticPublicNonVoid2.testString("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    private void testStringBuffer() {
        StringBuffer stringBuffer = TestStaticPublicNonVoid2.testStringBuffer("");
        assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());
    }

    private void testStringBuilder() {
        StringBuilder stringBuilder = TestStaticPublicNonVoid2.testStringBuilder("");
        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }

    private void testByteLower() {
        Mockito.when(TestStaticPublicNonVoid2.testByteLower(Mockito.anyString())).thenReturn((byte) 1);
        byte byte1 = TestStaticPublicNonVoid2.testByteLower("");
        assertEquals(1, byte1);
    }
}
