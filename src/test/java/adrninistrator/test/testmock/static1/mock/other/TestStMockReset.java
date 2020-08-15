package adrninistrator.test.testmock.static1.mock.other;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 当PowerMockito.mockStatic执行多次时，会使之前对静态方法设置的Stub均失效，未被Stub的方法返回默认值
public class TestStMockReset extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStMockReset.class);

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

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        logger.info("TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity) thenReturn: {}", str);
        assertNull(str);
    }
}
