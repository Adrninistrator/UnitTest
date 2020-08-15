package adrninistrator.test.testmock.static1.mock.defaultanswer;

import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为执行真实方法
    使用Mockito.withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS)
*/
public class TestStMockDftAnsCallsRealMethodsWS2 extends TestStMockDftAnsCallsRealMethodsBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, Mockito.withSettings().defaultAnswer(Answers
                .CALLS_REAL_METHODS));
    }
}
