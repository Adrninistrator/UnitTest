package adrninistrator.test.testmock.static1.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定Mockito.withSettings().defaultAnswer(DoesNothing.doesNothing())
    对于未被Stub的方法，返回值为null或基本类型的默认值
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsDoesNothing extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, DoesNothing.doesNothing());
    }

    @Test
    public void test() {
        testString();
        testStringBuffer();
        testStringBuilder();
        testByteLower();
        testByteUpper();
        testCharLower();
        testCharUpper();
        testBooleanLower();
        testBooleanUpper();
        testShortLower();
        testShortUpper();
        testInt();
        testInteger();
        testLongLower();
        testLongUpper();
        testFloatLower();
        testFloatUpper();
        testDoubleLower();
        testDoubleUpper();
        testBigDecimal();
        testTestTableEntity();
        testList();
        testMap();
    }

    private void testString() {
        String str = TestStaticPublicNonVoid2.testString("");
        assertNull(str);
    }

    private void testStringBuffer() {
        StringBuffer stringBuffer = TestStaticPublicNonVoid2.testStringBuffer("");
        assertNull(stringBuffer);
    }

    private void testStringBuilder() {
        StringBuilder stringBuilder = TestStaticPublicNonVoid2.testStringBuilder("");
        assertNull(stringBuilder);
    }

    private void testByteLower() {
        byte byte1 = TestStaticPublicNonVoid2.testByteLower("");
        assertEquals(0, byte1);
    }

    private void testByteUpper() {
        Byte byte2 = TestStaticPublicNonVoid2.testByteUpper("");
        assertNull(byte2);
    }

    private void testCharLower() {
        char char1 = TestStaticPublicNonVoid2.testCharLower("");
        assertEquals('\u0000', char1);
    }

    private void testCharUpper() {
        Character char2 = TestStaticPublicNonVoid2.testCharUpper("");
        assertNull(char2);
    }

    private void testBooleanLower() {
        boolean boolean1 = TestStaticPublicNonVoid2.testBooleanLower("");
        assertEquals(false, boolean1);
    }

    private void testBooleanUpper() {
        Boolean boolean2 = TestStaticPublicNonVoid2.testBooleanUpper("");
        assertNull(boolean2);
    }

    private void testShortLower() {
        short short1 = TestStaticPublicNonVoid2.testShortLower("");
        assertEquals(0, short1);
    }

    private void testShortUpper() {
        Short short2 = TestStaticPublicNonVoid2.testShortUpper("");
        assertNull(short2);
    }

    private void testInt() {
        int int1 = TestStaticPublicNonVoid2.testInt("");
        assertEquals(0, int1);
    }

    private void testInteger() {
        Integer integer = TestStaticPublicNonVoid2.testInteger("");
        assertNull(integer);
    }

    private void testLongLower() {
        long long1 = TestStaticPublicNonVoid2.testLongLower("");
        assertEquals(0, long1);
    }

    private void testLongUpper() {
        Long long2 = TestStaticPublicNonVoid2.testLongUpper("");
        assertNull(long2);
    }

    private void testFloatLower() {
        float float1 = TestStaticPublicNonVoid2.testFloatLower("");
        assertEquals(0, Float.compare(0F, float1));
    }

    private void testFloatUpper() {
        Float float2 = TestStaticPublicNonVoid2.testFloatUpper("");
        assertNull(float2);
    }

    private void testDoubleLower() {
        double double1 = TestStaticPublicNonVoid2.testDoubleLower("");
        assertEquals(0, Double.compare(0D, double1));
    }

    private void testDoubleUpper() {
        Double double2 = TestStaticPublicNonVoid2.testDoubleUpper("");
        assertNull(double2);
    }

    private void testBigDecimal() {
        BigDecimal bigDecimal = TestStaticPublicNonVoid2.testBigDecimal("");
        assertNull(bigDecimal);
    }

    private void testTestTableEntity() {
        TestTableEntity testTableEntity = TestStaticPublicNonVoid2.testTestTableEntity("");
        assertNull(testTableEntity);
    }

    private void testList() {
        List list = TestStaticPublicNonVoid2.testList("");
        assertNull(list);
    }

    private void testMap() {
        Map map = TestStaticPublicNonVoid2.testMap("");
        assertNull(map);
    }
}
