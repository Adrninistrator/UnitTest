package test.testmock.static1.mock.other;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

import java.math.BigDecimal;
import java.util.*;

//对于已被Stub的方法，当执行对应方法参数与Stub条件不匹配时，返回默认值
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockStubNotSatisfied extends TestStaticPublicNonVoidBase {

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

        Mockito.when(TestStaticPublicNonVoid2.testString(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);
        String str = TestStaticPublicNonVoid2.testString("");
        Assert.assertNull(str);
    }

    private void testStringBuffer() {

        Mockito.when(TestStaticPublicNonVoid2.testStringBuffer(TestConstants.FLAG1)).thenReturn(new StringBuffer()
                .append(TestConstants.MOCKED));
        StringBuffer stringBuffer = TestStaticPublicNonVoid2.testStringBuffer("");
        Assert.assertNull(stringBuffer);
    }

    private void testStringBuilder() {

        Mockito.when(TestStaticPublicNonVoid2.testStringBuilder(TestConstants.FLAG1)).thenReturn(new StringBuilder()
                .append(TestConstants.MOCKED));
        StringBuilder stringBuilder = TestStaticPublicNonVoid2.testStringBuilder("");
        Assert.assertNull(stringBuilder);
    }

    private void testByteLower() {
        Mockito.when(TestStaticPublicNonVoid2.testByteLower(TestConstants.FLAG1)).thenReturn((byte) 1);
        byte byte1 = TestStaticPublicNonVoid2.testByteLower("");
        Assert.assertEquals(0, byte1);
    }

    private void testByteUpper() {
        Mockito.when(TestStaticPublicNonVoid2.testByteUpper(TestConstants.FLAG1)).thenReturn(Byte.valueOf((byte) 1));
        Byte byte2 = TestStaticPublicNonVoid2.testByteUpper("");
        Assert.assertNotNull(byte2);
        Assert.assertEquals(0, byte2.byteValue());
    }

    private void testCharLower() {
        Mockito.when(TestStaticPublicNonVoid2.testCharLower(TestConstants.FLAG1)).thenReturn((char) 1);
        char char1 = TestStaticPublicNonVoid2.testCharLower("");
        Assert.assertEquals('\u0000', char1);
    }

    private void testCharUpper() {
        Mockito.when(TestStaticPublicNonVoid2.testCharUpper(TestConstants.FLAG1)).thenReturn(Character.valueOf((char)
                1));
        Character char2 = TestStaticPublicNonVoid2.testCharUpper("");
        Assert.assertNotNull(char2);
        Assert.assertEquals(0, char2.charValue());
    }

    private void testBooleanLower() {

        Mockito.when(TestStaticPublicNonVoid2.testBooleanLower(TestConstants.FLAG1)).thenReturn(false);
        boolean boolean1 = TestStaticPublicNonVoid2.testBooleanLower("");
        Assert.assertEquals(false, boolean1);
    }

    private void testBooleanUpper() {

        Mockito.when(TestStaticPublicNonVoid2.testBooleanUpper(TestConstants.FLAG1)).thenReturn(Boolean.TRUE);
        Boolean boolean2 = TestStaticPublicNonVoid2.testBooleanUpper("");
        Assert.assertNotNull(boolean2);
        Assert.assertEquals(Boolean.FALSE, boolean2);
    }

    private void testShortLower() {

        Mockito.when(TestStaticPublicNonVoid2.testShortLower(TestConstants.FLAG1)).thenReturn((short) 1);
        short short1 = TestStaticPublicNonVoid2.testShortLower("");
        Assert.assertEquals(0, short1);
    }

    private void testShortUpper() {

        Mockito.when(TestStaticPublicNonVoid2.testShortUpper(TestConstants.FLAG1)).thenReturn(Short.valueOf((short) 1));
        Short short2 = TestStaticPublicNonVoid2.testShortUpper("");
        Assert.assertNotNull(short2);
        Assert.assertEquals(0, short2.shortValue());
    }

    private void testInt() {

        Mockito.when(TestStaticPublicNonVoid2.testInt(TestConstants.FLAG1)).thenReturn(1);
        int int1 = TestStaticPublicNonVoid2.testInt("");
        Assert.assertEquals(0, int1);
    }

    private void testInteger() {

        Mockito.when(TestStaticPublicNonVoid2.testInteger(TestConstants.FLAG1)).thenReturn(Integer.valueOf(1));
        Integer integer = TestStaticPublicNonVoid2.testInteger("");
        Assert.assertNotNull(integer);
        Assert.assertEquals(0, integer.compareTo(0));
    }

    private void testLongLower() {

        Mockito.when(TestStaticPublicNonVoid2.testLongLower(TestConstants.FLAG1)).thenReturn(1L);
        long long1 = TestStaticPublicNonVoid2.testLongLower("");
        Assert.assertEquals(0L, long1);
    }

    private void testLongUpper() {

        Mockito.when(TestStaticPublicNonVoid2.testLongUpper(TestConstants.FLAG1)).thenReturn(Long.valueOf(1L));
        Long long2 = TestStaticPublicNonVoid2.testLongUpper("");
        Assert.assertNotNull(long2);
        Assert.assertEquals(0, long2.compareTo(0L));
    }

    private void testFloatLower() {

        Mockito.when(TestStaticPublicNonVoid2.testFloatLower(TestConstants.FLAG1)).thenReturn(1.0F);
        float float1 = TestStaticPublicNonVoid2.testFloatLower("");
        Assert.assertEquals(0, Float.compare(0F, float1));
    }

    private void testFloatUpper() {

        Mockito.when(TestStaticPublicNonVoid2.testFloatUpper(TestConstants.FLAG1)).thenReturn(Float.valueOf(1.0F));
        Float float2 = TestStaticPublicNonVoid2.testFloatUpper("");
        Assert.assertNotNull(float2);
        Assert.assertEquals(0, Float.valueOf(0F).compareTo(float2));
    }

    private void testDoubleLower() {

        Mockito.when(TestStaticPublicNonVoid2.testDoubleLower(TestConstants.FLAG1)).thenReturn(1.0D);
        double double1 = TestStaticPublicNonVoid2.testDoubleLower("");
        Assert.assertEquals(0, Double.compare(0D, double1));
    }

    private void testDoubleUpper() {

        Mockito.when(TestStaticPublicNonVoid2.testDoubleUpper(TestConstants.FLAG1)).thenReturn(Double.valueOf(1.0D));
        Double double2 = TestStaticPublicNonVoid2.testDoubleUpper("");
        Assert.assertNotNull(double2);
        Assert.assertEquals(0, Double.valueOf(0D).compareTo(double2));
    }

    private void testBigDecimal() {

        Mockito.when(TestStaticPublicNonVoid2.testBigDecimal(TestConstants.FLAG1)).thenReturn(BigDecimal.ONE);
        BigDecimal bigDecimal = TestStaticPublicNonVoid2.testBigDecimal("");
        Assert.assertNull(bigDecimal);
    }

    private void testTestTableEntity() {

        Mockito.when(TestStaticPublicNonVoid2.testTestTableEntity(TestConstants.FLAG1)).thenReturn(new
                TestTableEntity());
        TestTableEntity testTableEntity = TestStaticPublicNonVoid2.testTestTableEntity("");
        Assert.assertNull(testTableEntity);
    }

    private void testList() {

        Mockito.when(TestStaticPublicNonVoid2.testList(TestConstants.FLAG1)).thenReturn(new ArrayList(1));
        List list = TestStaticPublicNonVoid2.testList("");
        Assert.assertNotNull(list);
        Assert.assertTrue(list instanceof LinkedList);
        Assert.assertEquals(0, list.size());
    }

    private void testMap() {

        Mockito.when(TestStaticPublicNonVoid2.testMap(TestConstants.FLAG1)).thenReturn(new Hashtable(1));
        Map map = TestStaticPublicNonVoid2.testMap("");
        Assert.assertNotNull(map);
        Assert.assertTrue(map instanceof HashMap);
        Assert.assertEquals(0, map.size());
    }
}
