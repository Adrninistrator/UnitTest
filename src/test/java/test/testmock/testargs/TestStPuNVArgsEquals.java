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

//Mockito.when()的Stub参数条件为等于指定值
public class TestStPuNVArgsEquals extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVArgsEquals.class);

    @Test
    public void test1() {

        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity)).thenReturn(TestConstants
                .MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，不满足Stub的参数条件，返回数据应为null
        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        Integer integer1 = new Integer(10000);
        Integer integer2 = new Integer(integer1.intValue());

        Mockito.when(TestStaticPublicNonVoid1.test9(integer1)).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test9(integer1);
        //满足Stub条件
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid1.test9(integer2);
        //满足Stub条件
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
