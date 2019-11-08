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
import test.testmock.testargs.argmatcher.TestArgumentMatcherEntity;
import test.testmock.testargs.argmatcher.TestArgumentMatcherString1;
import test.testmock.testargs.argmatcher.TestArgumentMatcherString2;

//Mockito.when()的Stub参数条件使用Mockito.argThat()方法
//使用ArgumentMatcher实现类
public class TestStPuNVArgsArgThat extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsArgThat.class);

    @Test
    public void test1() {

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setFlag(TestConstants.FLAG1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(new TestArgumentMatcherString1()), Mockito
                .argThat(new TestArgumentMatcherEntity()))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(\"\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(new TestArgumentMatcherString2(TestConstants
                .FLAG1)), Mockito.any(TestTableEntity.class))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(\"\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        Assert.assertNull(str);
    }
}
