package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()的Stub参数条件使用Mockito.argThat()方法
// 使用匿名类
public class TestStPuNVArgsArgThatAnonymous extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsArgThatAnonymous.class);

    @Test
    public void test() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String argument) {
                logger.info("argument: {}", argument);

                return TestConstants.FLAG1.equals(argument);
            }
        }), Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.FLAG1);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.FLAG1, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }
}
