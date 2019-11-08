package test.testmock.other;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStatic1;
import com.test.non_static.TestNonStatic2;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockNoSpBase;

public class TestSetPrivateField extends TestMockNoSpBase {

    @Test
    public void test1() throws IllegalAccessException {

        TestNonStatic2 testNonStatic2 = new TestNonStatic2();

        PowerMockito.field(TestNonStatic2.class, "flag").set(testNonStatic2, TestConstants.FLAG1);

        Assert.assertEquals(TestConstants.FLAG1, testNonStatic2.getFlag());

        Whitebox.setInternalState(testNonStatic2, TestConstants.FLAG2);

        Assert.assertEquals(TestConstants.FLAG2, testNonStatic2.getFlag());

        Whitebox.setInternalState(testNonStatic2, "flag", TestConstants.FLAG3);

        Assert.assertEquals(TestConstants.FLAG3, testNonStatic2.getFlag());
    }

    @Test
    public void test2() {

        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        Whitebox.setInternalState(testNonStatic1, "str1", TestConstants.FLAG1);

        Whitebox.setInternalState(testNonStatic1, "str2", TestConstants.FLAG2);

        String value = testNonStatic1.getValue();

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS + TestConstants.FLAG2, value);
    }
}
