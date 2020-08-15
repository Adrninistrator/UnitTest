package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestStPuNVThenCallRealMethod extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenCallRealMethod.class);

    @Test
    public void test() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();

        // 执行TestStaticPublicNonVoid1.test1
        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        // 执行TestStaticPublicNonVoid1.test1方法，满足thenCallRealMethod的参数条件，返回数据应为原始值
        logger.info("TestStaticPublicNonVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", str);
        assertEquals(TestConstants.NOT_MOCKED, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
