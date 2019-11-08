package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid6;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//Mockito.when()的Stub参数条件使用Mockito.argThat()方法处理基本类型的参数
//Stub失败，以下方法执行结束时会出现失败，提示“Test mechanism.classMethod FAILED”
@PrepareForTest({TestStaticPublicNonVoid6.class})
public class TestStPuNVArgsArgThatPrimitiveWrong extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid6.class);
    }

    @Test
    public void test1() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testChar(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_CHAR))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test2() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testBoolean(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_BOOL))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test3() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testByte(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_BYTE))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test4() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testShort(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_SHORT))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test5() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testInt(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_INT))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test6() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testLong(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_LONG))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test7() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testFloat(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_FLOAT))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test8() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid6.testDouble(Mockito.argThat(argument -> argument == TestConstants
                .DEFAULT_DOUBLE))).thenReturn(TestConstants.MOCKED);
    }
}
