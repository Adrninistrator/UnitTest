package test.testmock.non_static.suppress.constructor;

import com.test.non_static.TestNonStatic1;
import com.test.non_static.TestNonStatic3;
import com.test.non_static.TestNonStatic4;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockNoSpBase;

public abstract class TestNStSuppressConstructorBase extends TestMockNoSpBase {

    @BeforeClass
    public static void initTestNStSuppressConstructorBase() {

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, true);
    }

    protected static void checkMember(TestNonStatic3 testNonStatic3, boolean notNull) {

        TestNonStatic1 testNonStatic1_a = testNonStatic3.getTestNonStatic1();
        Assert.assertEquals(notNull, testNonStatic1_a != null);

        TestNonStatic1 testNonStatic1_b = Whitebox.getInternalState(testNonStatic3, "testNonStatic1");
        Assert.assertEquals(notNull, testNonStatic1_b != null);
    }
}
