package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStatic1;
import com.adrninistrator.non_static.TestNonStatic2;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 替换私有成员变量
public class TestSetPrivateField extends TestMockNoSpBase {

    @Test
    public void test1() throws IllegalAccessException {

        TestNonStatic2 testNonStatic2 = new TestNonStatic2();

        PowerMockito.field(TestNonStatic2.class, "flag").set(testNonStatic2, TestConstants.FLAG1);

        assertEquals(TestConstants.FLAG1, testNonStatic2.getFlag());

        // 指定变量类型进行替换
        Whitebox.setInternalState(testNonStatic2, String.class, TestConstants.FLAG2);

        assertEquals(TestConstants.FLAG2, testNonStatic2.getFlag());

        // 直接指定变量进行替换
        Whitebox.setInternalState(testNonStatic2, TestConstants.FLAG3);

        assertEquals(TestConstants.FLAG3, testNonStatic2.getFlag());
    }

    @Test
    public void test2() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        // 指定变量名称进行替换
        Whitebox.setInternalState(testNonStatic1, "str1", TestConstants.FLAG1);
        Whitebox.setInternalState(testNonStatic1, "str2", TestConstants.FLAG2);

        String value = testNonStatic1.getValue();

        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS + TestConstants.FLAG2, value);
    }
}
