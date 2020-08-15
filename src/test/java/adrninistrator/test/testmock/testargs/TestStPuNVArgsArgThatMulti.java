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

// Mockito.when()的Stub参数条件使用Mockito.argThat()方法
// 对同一个方法设置多个自定义参数匹配器
public class TestStPuNVArgsArgThatMulti extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsArgThatMulti.class);

    // 对同一个方法的不同的Stub条件不会相互影响
    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument))
                , Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG2.equals(argument))
                , Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.FLAG1, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.FLAG2, str);
    }

    // 对同一个方法的相同条件的Stub，最后一次的生效
    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument))
                , Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument))
                , Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，最后一次Stub生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
