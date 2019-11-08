package test.testmock.static1.mock.public1.non_void.answer;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.common.TestCommonUtil;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

import java.util.Arrays;

//检查参数是否符合预期
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
                    String arg2 = TestCommonUtil.getMockArg(invocation, 1, String.class);
                    TestTableEntity arg3 = TestCommonUtil.getMockArg(invocation, 2, TestTableEntity.class);

                    Assert.assertEquals(value, arg1);
                    Assert.assertEquals(TestConstants.FLAG1, arg2);
                    Assert.assertEquals(TestConstants.FLAG1, arg3.getId());
                    Assert.assertEquals(TestConstants.FLAG1, arg3.getFlag());

                    //调用真实方法
                    return invocation.callRealMethod();
                }
        );

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        String str = TestStaticPublicNonVoid1.test6(value, TestConstants.FLAG1, testTableEntity);
        //返回值应为真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
