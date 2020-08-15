package adrninistrator.test.testmock.static1.mock.public1.non_void.answer;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class AnswerStaticPublicNonVoid1 implements Answer<String> {

    @Override
    public String answer(InvocationOnMock invocation) throws Throwable {

        // 调用真实方法
        return (String) invocation.callRealMethod();
    }
}
