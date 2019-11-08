package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//执行真实方法
public class TestStPuNVThenCallRealMethod extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenCallRealMethod.class);

    @Test
    public void test() {

        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();

        //执行TestStaticPublicNonVoid1.test1
        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        //执行TestStaticPublicNonVoid1.test1方法，满足thenCallRealMethod的参数条件，返回数据应为原始值
        logger.info("TestStaticPublicNonVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", str);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
