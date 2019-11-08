package test.testmock.static1.effective.base;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.AfterClass;
import org.junit.Assert;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public abstract class TestStEffectiveBase extends TestMockNoSpBase {

    @AfterClass
    public static void afterClass() {

        String str = TestStaticPublicNonVoid1.test4("");

        //未被Mock、Stub、Replace、Suppress的方法不受影响
        Assert.assertEquals(TestConstants.MINUS, str);
    }
}
