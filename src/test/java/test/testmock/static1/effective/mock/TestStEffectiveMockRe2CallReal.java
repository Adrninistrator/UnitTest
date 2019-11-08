package test.testmock.static1.effective.mock;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.static1.effective.base.TestStEffectiveBase;

//Mockito.when()与PowerMockito.replace()的生效情况
//不满足Mockito.when()的条件，且执行真实方法
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

        //PowerMockito.doReturn().when()条件不满足，执行真实方法，PowerMockito.replace().with()生效
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
