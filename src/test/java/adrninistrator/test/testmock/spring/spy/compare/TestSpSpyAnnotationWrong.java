package adrninistrator.test.testmock.spring.spy.compare;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Spy;

// 创建Spy对象，使用@Spy注解，错误使用方式
// 执行时会失败，提示classMethod FAILED
public class TestSpSpyAnnotationWrong extends TestMockBase {

    @Spy
    private TestPublicNonVoidService1 testPublicNonVoidService1AtSpy1;

    @Test
    public void test() {
    }
}
