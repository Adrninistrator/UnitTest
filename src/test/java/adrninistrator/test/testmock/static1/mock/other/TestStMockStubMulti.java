package adrninistrator.test.testmock.static1.mock.other;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 当多次对具有相同参数的相同方法进行Stub时，最后一次执行的Stub会生效
public class TestStMockStubMulti extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStMockStubMulti.class);

    @Test
    public void test() {
        TestTableEntity testTableEntity = new TestTableEntity();

        // 
        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity)).thenReturn
                (TestConstants.FLAG1);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        assertEquals(TestConstants.FLAG1, str);

        // 
        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity)).thenReturn
                (TestConstants.FLAG2);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        // 执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为参数匹配的最后一次Stub指定的值
        assertEquals(TestConstants.FLAG2, str);
    }
}
