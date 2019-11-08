package test.testmock.spring.mock.delegatesto;

import com.test.service.TestServiceA1;
import org.junit.Before;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

//委托方法调用
public class TestSpMockDelegatesTo1 extends TestSpMockDelegatesToBase {

    @Before
    public void init() {

        testServiceA1 = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestServiceA1Delegate()));
    }
}
