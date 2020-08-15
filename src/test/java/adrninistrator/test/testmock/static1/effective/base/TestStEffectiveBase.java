package adrninistrator.test.testmock.static1.effective.base;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.AfterClass;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public abstract class TestStEffectiveBase extends TestMockNoSpBase {

    @AfterClass
    public static void afterClass() {
        String str = TestStaticPublicNonVoid1.test4("");

        // 未被Mock、Stub、Replace、Suppress的方法不受影响
        assertEquals(TestConstants.MINUS, str);
    }
}
