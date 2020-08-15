package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 修改返回值
// 在类级别使用@PrepareForTest注解
public class TestStPuNVThenReturnPrepareClass extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenReturnPrepareClass.class);

    @Test
    public void test1() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity)).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));
    }

    // Mockito.when支持的功能，PowerMockito.when也支持
    @Test
    public void test2() {
        TestTableEntity testTableEntity = new TestTableEntity();

        PowerMockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity)).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
