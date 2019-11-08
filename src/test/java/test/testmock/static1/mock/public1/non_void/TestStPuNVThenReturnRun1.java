package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.base.TestMockNoSpBase;

//修改返回值，在不包含@Before、@Test注解的类中执行Mock、Stub等操作
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStPuNVThenReturnRun1 extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenReturnRun1.class);

    @Test
    public void test() {

        TestStPuNVThenReturnMock1.mock();

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        logger.info("TestStaticPublicNonVoid1.test1(\"\", new TestTableEntity()) thenReturn: {}", str);
        //执行TestStaticPublicNonVoid1.test1方法，满足Stub的参数条件，返回数据应为Stub指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
