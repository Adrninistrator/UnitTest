package test.testmock.spring.mock.delegatesto;

import com.test.applicationlistener.TestApplicationListener;
import com.test.service.TestServiceA1;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//委托方法调用，被调用的方法在被委托对象中不存在匹配的方法
public class TestSpMockDelegatesToWrong extends TestMockBase {

    @Test
    public void test() {

        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestApplicationListener()));

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        testServiceA1.test1("");
    }
}
