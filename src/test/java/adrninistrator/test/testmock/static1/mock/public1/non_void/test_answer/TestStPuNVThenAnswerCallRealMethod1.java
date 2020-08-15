package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import adrninistrator.test.testmock.static1.mock.public1.non_void.answer.AnswerStaticPublicNonVoid1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestStPuNVThenAnswerCallRealMethod1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new AnswerStaticPublicNonVoid1());

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        return (String) invocation.callRealMethod();
                    }
                });

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test3() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenAnswer(invocation -> {
                            // 调用真实方法
                            return invocation.callRealMethod();
                        }
                );

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test4() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenAnswer(invocation -> TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test5() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenAnswer(invocation -> invocation.callRealMethod());

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
