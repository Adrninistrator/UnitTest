package test.testmock.static1.suppress.field;

import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid5;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//获取被Suppress属性的值
@PrepareForTest({TestStaticPublicNonVoid5.class})
public class TestStSuppressFieldValue1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.methodsDeclaredIn(TestStaticPublicNonVoid5.class));

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

        String str = TestStaticPublicNonVoid5.getString();
        Assert.assertNull(str);
    }

    private void testStringBuffer() {

        StringBuffer stringBuffer = TestStaticPublicNonVoid5.getStringBuffer();
        Assert.assertNull(stringBuffer);
    }

    private void testStringBuilder() {

        StringBuilder stringBuilder = TestStaticPublicNonVoid5.getStringBuilder();
        Assert.assertNull(stringBuilder);
    }

    private void testByteLower() {

        byte byte1 = TestStaticPublicNonVoid5.getByteLower();
        Assert.assertEquals(0, byte1);
    }

    private void testByteUpper() {

        Byte byte2 = TestStaticPublicNonVoid5.getByteUpper();
        Assert.assertNull(byte2);
    }

    private void testCharLower() {

        char char1 = TestStaticPublicNonVoid5.getCharLower();
        //char的返回值为空格
        Assert.assertEquals(' ', char1);
    }

    private void testCharUpper() {

        Character char2 = TestStaticPublicNonVoid5.getCharUpper();
        Assert.assertNull(char2);
    }

    private void testBooleanLower() {

        boolean boolean1 = TestStaticPublicNonVoid5.getBooleanLower();
        Assert.assertEquals(false, boolean1);
    }

    private void testBooleanUpper() {

        Boolean boolean2 = TestStaticPublicNonVoid5.getBooleanUpper();
        Assert.assertNull(boolean2);
    }

    private void testShortLower() {

        short short1 = TestStaticPublicNonVoid5.getShortLower();
        Assert.assertEquals(0, short1);
    }

    private void testShortUpper() {

        Short short2 = TestStaticPublicNonVoid5.getShortUpper();
        Assert.assertNull(short2);
    }

    private void testInt() {

        int int1 = TestStaticPublicNonVoid5.getInt();
        Assert.assertEquals(0, int1);
    }

    private void testInteger() {

        Integer integer1 = TestStaticPublicNonVoid5.getInteger();
        Assert.assertNull(integer1);
    }

    private void testLongLower() {

        long long1 = TestStaticPublicNonVoid5.getLongLower();
        Assert.assertEquals(0L, long1);
    }

    private void testLongUpper() {

        Long long2 = TestStaticPublicNonVoid5.getLongUpper();
        Assert.assertNull(long2);
    }

    private void testFloatLower() {

        float float1 = TestStaticPublicNonVoid5.getFloatLower();
        Assert.assertEquals(0, Float.compare(0.0F, float1));
    }

    private void testFloatUpper() {

        Float float2 = TestStaticPublicNonVoid5.getFloatUpper();
        Assert.assertNull(float2);
    }

    private void testDoubleLower() {

        double double1 = TestStaticPublicNonVoid5.getDoubleLower();
        Assert.assertEquals(0, Double.compare(0.0D, double1));
    }

    private void testDoubleUpper() {

        Double double2 = TestStaticPublicNonVoid5.getDoubleUpper();
        Assert.assertNull(double2);
    }

    private void testBigDecimal() {

        BigDecimal bigDecimal = TestStaticPublicNonVoid5.getBigDecimal();
        Assert.assertNull(bigDecimal);
    }

    private void testTestTableEntity() {

        TestTableEntity testTableEntity = TestStaticPublicNonVoid5.getTestTableEntity();
        Assert.assertNull(testTableEntity);
    }

    private void testList() {

        List list = TestStaticPublicNonVoid5.getList();
        Assert.assertNull(list);
    }

    private void testMap() {

        Map map = TestStaticPublicNonVoid5.getMap();
        Assert.assertNull(map);
    }
}
