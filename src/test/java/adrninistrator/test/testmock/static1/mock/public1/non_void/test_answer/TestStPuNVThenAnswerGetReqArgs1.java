package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.common.TestCommonUtil;
import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

// 检查参数是否符合预期
public class TestStPuNVThenAnswerGetReqArgs1 extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenAnswerGetReqArgs1.class);

    @Test
    public void test() {
        int value = 123;

        Mockito.when(TestStaticPublicNonVoid1.test6(Mockito.anyInt(), Mockito.anyString(), Mockito.any
                (TestTableEntity.class))).thenAnswer(invocation -> {

                    Object[] objects = invocation.getArguments();
                    logger.info("getArguments: {}", Arrays.toString(objects));

                    int arg1 = TestCommonUtil.getMockArg(invocation, 0, Integer.class);
                    String arg2 = invocation.getArgument(1, String.class);
                    TestTableEntity arg3 = invocation.getArgument(2);

                    assertEquals(value, arg1);
                    assertEquals(TestConstants.FLAG1, arg2);
                    assertEquals(TestConstants.FLAG1, arg3.getId());
                    assertEquals(TestConstants.FLAG1, arg3.getFlag());

                    // 调用真实方法
                    return invocation.callRealMethod();
                }
        );

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        String str = TestStaticPublicNonVoid1.test6(value, TestConstants.FLAG1, testTableEntity);
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
