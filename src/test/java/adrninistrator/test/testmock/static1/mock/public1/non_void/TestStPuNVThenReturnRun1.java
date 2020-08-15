package adrninistrator.test.testmock.static1.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 修改返回值，在不包含@Before、@Test注解的类中执行Mock、Stub等操作
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStPuNVThenReturnRun1 extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenReturnRun1.class);

    @Test
    public void test() {
        TestStPuNVThenReturnMock1.mock();

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(\"\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
