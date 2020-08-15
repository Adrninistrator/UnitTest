package adrninistrator.test.testmock.static1.mock.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

// 使用PowerMockito.mockStatic方法对类进行Mock，对于未被Stub的方法，返回默认值
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockUnstubbedMethod extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class);
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
        assertNotNull(byte2);
        assertEquals(0, byte2.byteValue());
    }

    private void testCharLower() {
        char char1 = TestStaticPublicNonVoid2.testCharLower("");
        assertEquals('\u0000', char1);
    }

    private void testCharUpper() {
        Character char2 = TestStaticPublicNonVoid2.testCharUpper("");
        assertNotNull(char2);
        assertEquals(0, char2.charValue());
    }

    private void testBooleanLower() {
        boolean boolean1 = TestStaticPublicNonVoid2.testBooleanLower("");
        assertEquals(false, boolean1);
    }

    private void testBooleanUpper() {
        Boolean boolean2 = TestStaticPublicNonVoid2.testBooleanUpper("");
        assertNotNull(boolean2);
        assertEquals(Boolean.FALSE, boolean2);
    }

    private void testShortLower() {
        short short1 = TestStaticPublicNonVoid2.testShortLower("");
        assertEquals(0, short1);
    }

    private void testShortUpper() {
        Short short2 = TestStaticPublicNonVoid2.testShortUpper("");
        assertNotNull(short2);
        assertEquals(0, short2.shortValue());
    }

    private void testInt() {
        int int1 = TestStaticPublicNonVoid2.testInt("");
        assertEquals(0, int1);
    }

    private void testInteger() {
        Integer integer = TestStaticPublicNonVoid2.testInteger("");
        assertNotNull(integer);
        assertEquals(0, integer.compareTo(0));
    }

    private void testLongLower() {
        long long1 = TestStaticPublicNonVoid2.testLongLower("");
        assertEquals(0L, long1);
    }

    private void testLongUpper() {
        Long long2 = TestStaticPublicNonVoid2.testLongUpper("");
        assertNotNull(long2);
        assertEquals(0, long2.compareTo(0L));
    }

    private void testFloatLower() {
        float float1 = TestStaticPublicNonVoid2.testFloatLower("");
        assertEquals(0, Float.compare(0F, float1));
    }

    private void testFloatUpper() {
        Float float2 = TestStaticPublicNonVoid2.testFloatUpper("");
        assertNotNull(float2);
        assertEquals(0, Float.valueOf(0F).compareTo(float2));
    }

    private void testDoubleLower() {
        double double1 = TestStaticPublicNonVoid2.testDoubleLower("");
        assertEquals(0, Double.compare(0D, double1));
    }

    private void testDoubleUpper() {
        Double double2 = TestStaticPublicNonVoid2.testDoubleUpper("");
        assertNotNull(double2);
        assertEquals(0, Double.valueOf(0D).compareTo(double2));
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
        assertNotNull(list);
        assertTrue(list instanceof LinkedList);
        assertEquals(0, list.size());
    }

    private void testMap() {
        Map map = TestStaticPublicNonVoid2.testMap("");
        assertNotNull(map);
        assertTrue(map instanceof HashMap);
        assertEquals(0, map.size());
    }
}
