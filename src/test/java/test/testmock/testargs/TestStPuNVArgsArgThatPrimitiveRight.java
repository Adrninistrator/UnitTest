package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//Mockito.when()的Stub参数条件使用Mockito.charThat()等方法处理基本类型的参数
//Stub成功
@PrepareForTest({TestStaticPublicNonVoid6.class})
public class TestStPuNVArgsArgThatPrimitiveRight extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid6.class);
    }

    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid6.testChar(Mockito.charThat(argument -> argument == TestConstants
                .DEFAULT_CHAR))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testChar(TestConstants.DEFAULT_CHAR);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid6.testBoolean(Mockito.booleanThat(argument -> argument == TestConstants
                .DEFAULT_BOOL))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testBoolean(TestConstants.DEFAULT_BOOL);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test3() {

        Mockito.when(TestStaticPublicNonVoid6.testByte(Mockito.byteThat(argument -> argument == TestConstants
                .DEFAULT_BYTE))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testByte(TestConstants.DEFAULT_BYTE);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test4() {

        Mockito.when(TestStaticPublicNonVoid6.testShort(Mockito.shortThat(argument -> argument == TestConstants
                .DEFAULT_SHORT))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testShort(TestConstants.DEFAULT_SHORT);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test5() {

        Mockito.when(TestStaticPublicNonVoid6.testInt(Mockito.intThat(argument -> argument == TestConstants
                .DEFAULT_INT))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testInt(TestConstants.DEFAULT_INT);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test6() {

        Mockito.when(TestStaticPublicNonVoid6.testLong(Mockito.longThat(argument -> argument == TestConstants
                .DEFAULT_LONG))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testLong(TestConstants.DEFAULT_LONG);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test7() {

        Mockito.when(TestStaticPublicNonVoid6.testFloat(Mockito.floatThat(argument -> argument == TestConstants
                .DEFAULT_FLOAT))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testFloat(TestConstants.DEFAULT_FLOAT);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test8() {

        Mockito.when(TestStaticPublicNonVoid6.testDouble(Mockito.doubleThat(argument -> argument == TestConstants
                .DEFAULT_DOUBLE))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid6.testDouble(TestConstants.DEFAULT_DOUBLE);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
