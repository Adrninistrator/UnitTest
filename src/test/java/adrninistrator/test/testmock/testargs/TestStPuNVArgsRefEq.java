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

// Mockito.when()的Stub参数条件为：当调用参数与指定对象通过反射获取成员变量的值均相同时，Stub条件生效
public class TestStPuNVArgsRefEq extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsRefEq.class);

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.refEq(TestConstants.FLAG1), Mockito.any(TestTableEntity
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
        testTableEntity2.setFlag(testTableEntity1.getFlag());
        testTableEntity2.setId(testTableEntity1.getId());

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.refEq(testTableEntity1)))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }

    @Test
    public void test3() {
        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);
        testTableEntity1.setId(TestConstants.FLAG2);

        TestTableEntity testTableEntity2 = new TestTableEntity();
        testTableEntity2.setFlag(testTableEntity1.getFlag());
        testTableEntity2.setId(testTableEntity1.getId() + TestConstants.MINUS);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.refEq(testTableEntity1, "id")))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity2) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }

    @Test
    public void test4() {
        Integer integer1 = new Integer(10000);
        Integer integer2 = new Integer(integer1.intValue());
        Integer integer3 = new Integer(10001);

        Mockito.when(TestStaticPublicNonVoid1.test9(Mockito.refEq(integer1))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test9(integer1);
        // 满足Stub条件
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test9(integer2);
        // 满足Stub条件
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test9(integer3);
        // 不满足Stub条件
        assertNull(str);
    }
}
