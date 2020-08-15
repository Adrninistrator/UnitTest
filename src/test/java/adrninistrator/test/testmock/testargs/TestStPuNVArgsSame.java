package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()的Stub参数条件为：调用参数与指定对象为同一个对象
public class TestStPuNVArgsSame extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsSame.class);

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.same(TestConstants.FLAG1), Mockito.any(TestTableEntity
                .class))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }

    @Test
    public void test2() {
        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);
        testTableEntity1.setId(TestConstants.FLAG1);

        TestTableEntity testTableEntity2 = new TestTableEntity();
        testTableEntity2.setFlag(TestConstants.FLAG1);
        testTableEntity2.setId(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.same(testTableEntity1)))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }

    @Test
    public void test3() {
        Integer integer1 = new Integer(10000);
        Integer integer2 = new Integer(integer1.intValue());

        Mockito.when(TestStaticPublicNonVoid1.test9(Mockito.same(integer1))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test9(integer1);
        // 满足Stub条件
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test9(integer2);
        // 不满足Stub条件
        assertNull(str);
    }
}
