package adrninistrator.test.testmock.static1.mock.private1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 修改返回值，对于有参数的方法的Stub
public class TestStPrNVThenReturn1 extends TestStaticPrivateNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrNVThenReturn1.class);

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1);

        TestTableEntity testTableEntity = new TestTableEntity();

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants.FLAG1,
                testTableEntity).thenReturn(TestConstants.MOCKED);

        String str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,
                TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPrivateNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPrivateNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法应未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1);

        TestTableEntity testTableEntity = new TestTableEntity();

        // 指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants.FLAG1,
                testTableEntity).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPrivateNonVoid1.testPublic1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPrivateNonVoid1.testPublic1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPrivateNonVoid1.testPublic1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法应未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }
}
