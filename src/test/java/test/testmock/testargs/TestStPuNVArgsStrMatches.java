package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

import java.util.regex.Pattern;

//Mockito.when()的Stub参数条件为：为String类型，且满足指定的正则表达式
public class TestStPuNVArgsStrMatches extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsStrMatches.class);

    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.matches("[0-9]{4}"), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("1234", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"1234\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("a", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"a\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.matches(Pattern.compile("[0-9]{4}")), Mockito.any
                (TestTableEntity.class))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("1234", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"1234\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("a", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1 (\"a\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        Assert.assertNull(str);
    }
}
