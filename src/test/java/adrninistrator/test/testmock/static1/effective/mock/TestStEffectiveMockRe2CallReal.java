package adrninistrator.test.testmock.static1.effective.mock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// Mockito.when()与PowerMockito.replace()的生效情况
// 不满足Mockito.when()的条件，且执行真实方法
public class TestStEffectiveMockRe2CallReal extends TestStEffectiveBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class, new CallsRealMethods());
    }

    @Test
    public void test() throws Exception {

        PowerMockito.doReturn(TestConstants.FLAG1).when(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4, TestConstants.FLAG1);

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .with((proxy, method, args) -> TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test4("");

        // PowerMockito.doReturn().when()条件不满足，执行真实方法，PowerMockito.replace().with()生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
