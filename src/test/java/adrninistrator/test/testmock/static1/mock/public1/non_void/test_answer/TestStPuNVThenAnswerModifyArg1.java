package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 修改调用参数并执行真实方法
public class TestStPuNVThenAnswerModifyArg1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        int init = 100;

        Integer integer = Integer.valueOf(init);

        int modify = 123;

        Mockito.when(TestStaticPublicNonVoid1.test7(Mockito.any(Integer.class))).thenAnswer(invocation -> {

                    Integer arg1 = invocation.getArgument(0);

                    // 通过反射修改请求参数1的int值为modify变量对应值
                    Whitebox.setInternalState(arg1, "value", modify);

                    return invocation.callRealMethod();
                }
        );

        assertEquals(init, integer.intValue());

        int result = TestStaticPublicNonVoid1.test7(integer);
        // 返回值应为修改后的值
        assertEquals(modify, result);

        // 请求参数值也被修改
        assertEquals(modify, integer.intValue());
    }

    @Test
    public void test2() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class, new CallsRealMethods());

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);

        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(invocation -> {

                    String arg1 = invocation.getArgument(0);

                    // 通过反射修改请求参数1的字符串内容为TestConstants.FLAG2对应值
                    Whitebox.setInternalState(arg1, "value", TestConstants.FLAG2.toCharArray());

                    return invocation.callRealMethod();
                }
        );

        String arg = new String(TestConstants.FLAG1);

        str = TestStaticPublicNonVoid1.test4(arg);
        // 返回值应为TestConstants.FLAG2 + TestConstants.MINUS
        assertEquals(TestConstants.FLAG2 + TestConstants.MINUS, str);

        // 请求参数值也被修改
        assertEquals(TestConstants.FLAG2, arg);
    }

    @Test
    public void test3() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test5(Mockito.any(TestTableEntity.class))).thenAnswer(invocation -> {

                    TestTableEntity arg1 = invocation.getArgument(0);

                    // 修改请求参数1的id变量
                    arg1.setId(TestConstants.FLAG2);

                    return invocation.callRealMethod();
                }
        );

        String str = TestStaticPublicNonVoid1.test5(testTableEntity);
        // 返回值应为TestConstants.FLAG2 + TestConstants.MINUS
        assertEquals(TestConstants.FLAG2 + TestConstants.MINUS, str);

        // 请求参数值也被修改
        assertEquals(TestConstants.FLAG2, testTableEntity.getId());
    }
}
