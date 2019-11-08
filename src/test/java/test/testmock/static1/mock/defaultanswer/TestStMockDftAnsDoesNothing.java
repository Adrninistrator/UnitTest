package test.testmock.static1.mock.defaultanswer;

import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定Mockito.withSettings().defaultAnswer(DoesNothing.doesNothing())
    对于未被Stub的方法，返回值为null或基本类型的默认值
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsDoesNothing extends TestStaticPublicNonVoidBase {

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
        Assert.assertNull(str);
    }

    private void testStringBuffer() {

        StringBuffer stringBuffer = TestStaticPublicNonVoid2.testStringBuffer("");
        Assert.assertNull(stringBuffer);
    }

    private void testStringBuilder() {

        StringBuilder stringBuilder = TestStaticPublicNonVoid2.testStringBuilder("");
        Assert.assertNull(stringBuilder);
    }

    private void testByteLower() {

        byte byte1 = TestStaticPublicNonVoid2.testByteLower("");
        Assert.assertEquals(0, byte1);
    }

    private void testByteUpper() {

        Byte byte2 = TestStaticPublicNonVoid2.testByteUpper("");
        Assert.assertNull(byte2);
    }

    private void testCharLower() {

        char char1 = TestStaticPublicNonVoid2.testCharLower("");
        Assert.assertEquals('\u0000', char1);
    }

    private void testCharUpper() {

        Character char2 = TestStaticPublicNonVoid2.testCharUpper("");
        Assert.assertNull(char2);
    }

    private void testBooleanLower() {

        boolean boolean1 = TestStaticPublicNonVoid2.testBooleanLower("");
        Assert.assertEquals(false, boolean1);
    }

    private void testBooleanUpper() {

        Boolean boolean2 = TestStaticPublicNonVoid2.testBooleanUpper("");
        Assert.assertNull(boolean2);
    }

    private void testShortLower() {

        short short1 = TestStaticPublicNonVoid2.testShortLower("");
        Assert.assertEquals(0, short1);
    }

    private void testShortUpper() {

        Short short2 = TestStaticPublicNonVoid2.testShortUpper("");
        Assert.assertNull(short2);
    }

    private void testInt() {

        int int1 = TestStaticPublicNonVoid2.testInt("");
        Assert.assertEquals(0, int1);
    }

    private void testInteger() {

        Integer integer = TestStaticPublicNonVoid2.testInteger("");
        Assert.assertNull(integer);
    }

    private void testLongLower() {

        long long1 = TestStaticPublicNonVoid2.testLongLower("");
        Assert.assertEquals(0, long1);
    }

    private void testLongUpper() {

        Long long2 = TestStaticPublicNonVoid2.testLongUpper("");
        Assert.assertNull(long2);
    }

    private void testFloatLower() {

        float float1 = TestStaticPublicNonVoid2.testFloatLower("");
        Assert.assertEquals(0, Float.compare(0F, float1));
    }

    private void testFloatUpper() {

        Float float2 = TestStaticPublicNonVoid2.testFloatUpper("");
        Assert.assertNull(float2);
    }

    private void testDoubleLower() {

        double double1 = TestStaticPublicNonVoid2.testDoubleLower("");
        Assert.assertEquals(0, Double.compare(0D, double1));
    }

    private void testDoubleUpper() {

        Double double2 = TestStaticPublicNonVoid2.testDoubleUpper("");
        Assert.assertNull(double2);
    }

    private void testBigDecimal() {

        BigDecimal bigDecimal = TestStaticPublicNonVoid2.testBigDecimal("");
        Assert.assertNull(bigDecimal);
    }

    private void testTestTableEntity() {

        TestTableEntity testTableEntity = TestStaticPublicNonVoid2.testTestTableEntity("");
        Assert.assertNull(testTableEntity);
    }

    private void testList() {

        List list = TestStaticPublicNonVoid2.testList("");
        Assert.assertNull(list);
    }

    private void testMap() {

        Map map = TestStaticPublicNonVoid2.testMap("");
        Assert.assertNull(map);
    }
}
