package adrninistrator.test.testmock.static1.mock.defaultanswer;

import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为执行真实方法
    使用new CallsRealMethods()
*/
public class TestStMockDftAnsCallsRealMethodsA3 extends TestStMockDftAnsCallsRealMethodsBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new CallsRealMethods());
    }
}
