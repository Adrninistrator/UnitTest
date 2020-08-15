package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// 判断指定方法是否执行
public class TestStPuNVThenAnswerCheckCalled1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test() {
        TestAnswer testAnswer = new TestAnswer(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(testAnswer);

        TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        // 调用参数非TestConstants.FLAG1时，执行方法后标志仍为false
        assertFalse(testAnswer.isCalled());

        TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 调用参数为TestConstants.FLAG1时，执行方法后标志变为true
        assertTrue(testAnswer.isCalled());
    }

    static class TestAnswer implements Answer<String> {

        private boolean called;
        private String flag;

        public TestAnswer(String flag) {
            this.flag = flag;
        }

        public boolean isCalled() {
            return called;
        }

        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {

            String arg1 = invocation.getArgument(0);

            if (flag.equals(arg1)) {
                called = true;
            }

            return TestConstants.MOCKED;
        }
    }
}
