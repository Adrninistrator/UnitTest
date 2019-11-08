package test.testmock.static1.mock.public1.non_void.answer;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import test.common.TestCommonUtil;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//判断指定方法是否执行
public class TestStPuNVThenAnswerCheckCalled1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test() {

        TestAnswer testAnswer = new TestAnswer(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(testAnswer);

        TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        //调用参数非TestConstants.FLAG1时，执行方法后标志仍为false
        Assert.assertFalse(testAnswer.isCalled());

        TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        //调用参数为TestConstants.FLAG1时，执行方法后标志变为true
        Assert.assertTrue(testAnswer.isCalled());
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

            String arg1 = TestCommonUtil.getMockArg(invocation, 0, String.class);

            if (flag.equals(arg1)) {
                called = true;
            }

            return TestConstants.MOCKED;
        }
    }

}
