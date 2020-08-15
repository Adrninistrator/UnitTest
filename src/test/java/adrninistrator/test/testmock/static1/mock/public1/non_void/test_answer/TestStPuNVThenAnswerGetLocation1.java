package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.invocation.InterceptedInvocation;
import org.mockito.invocation.Location;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 获取调用方法信息
public class TestStPuNVThenAnswerGetLocation1 extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenAnswerGetLocation1.class);

    @Test
    public void test() {
        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(invocation -> {

                    assertEquals(InterceptedInvocation.class, invocation.getClass());
                    logger.info("invocation.getClass().getName(): {}", invocation.getClass().getName());

                    // 获取调用方法的代码信息
                    Location location = Whitebox.getInternalState(invocation, Location.class);

                    assertEquals(LocationImpl.class, location.getClass());
                    logger.info("location.getClass().getName(): {}", location.getClass().getName());
                    logger.info("location.toString(): {}", location);
                    logger.info("location.getSourceFile(): {}", location.getSourceFile());

                    // 调用真实方法
                    return invocation.callRealMethod();
                }
        );

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);
    }
}
