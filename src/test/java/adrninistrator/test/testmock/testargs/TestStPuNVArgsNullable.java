package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// Mockito.when()的Stub参数条件为指定类型，或为null
public class TestStPuNVArgsNullable extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsNullable.class);

    @Before
    public void init() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.nullable(String.class), Mockito.nullable(TestTableEntity
                .class))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(\"\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        String str = TestStaticPublicNonVoid1.test1(null, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(null, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test3() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        logger.info("TestStaticPublicNonVoid1.test1(\"\", null) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test4() {
        String str = TestStaticPublicNonVoid1.test1(null, null);
        logger.info("TestStaticPublicNonVoid1.test1(null, null) thenReturn: {}", str);
        logger.info("TestStaticPublicNonVoid1.test1(null, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);
    }
}
