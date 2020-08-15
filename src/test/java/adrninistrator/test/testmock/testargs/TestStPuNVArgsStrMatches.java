package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()的Stub参数条件为：为String类型，且满足指定的正则表达式
public class TestStPuNVArgsStrMatches extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsStrMatches.class);

    public static final Pattern pattern1 = Pattern.compile("[0-9]{4}");

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.matches("[0-9]{4}"), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("1234", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"1234\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("a", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"a\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.matches(pattern1), Mockito.any
                (TestTableEntity.class))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("1234", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"1234\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("a", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"a\", new TestTableEntity()) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        assertNull(str);
    }
}
