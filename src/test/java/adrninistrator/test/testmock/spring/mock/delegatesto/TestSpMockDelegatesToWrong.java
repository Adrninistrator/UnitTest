package adrninistrator.test.testmock.spring.mock.delegatesto;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.applicationlistener.TestApplicationListener;
import com.adrninistrator.service.TestServiceA1;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

// 委托方法调用，被调用的方法在被委托对象中不存在匹配的方法
public class TestSpMockDelegatesToWrong extends TestMockBase {

    @Test
    public void test() {
        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestApplicationListener()));

        assertThrows(Exception.class, () ->
                testServiceA1.test1("")
        );
    }
}
