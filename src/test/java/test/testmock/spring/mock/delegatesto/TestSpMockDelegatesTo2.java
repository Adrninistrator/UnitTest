package test.testmock.spring.mock.delegatesto;

import com.test.service.TestServiceA1;
import org.junit.Before;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

//委托方法调用，使用Spring的@Component组件
public class TestSpMockDelegatesTo2 extends TestSpMockDelegatesToBase {

    @Autowired
    private TestServiceA1Delegate testServiceA1Delegate;

    @Before
    public void init() {

        testServiceA1 = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(testServiceA1Delegate));
    }
}
