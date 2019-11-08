package test.testmock.static1.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPrivateNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPrNVVerifyCaptor extends TestStaticPrivateNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrNVVerifyCaptor.class);

    @Test
    public void test() throws Exception {

        //创建两个ArgumentCaptor，分别对应TestStaticPrivateNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2 = ArgumentCaptor.forClass(TestTableEntity.class);

        //调用TestStaticPrivateNonVoid1.test1方法
        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);
        logger.info("testTableEntity1.hashCode(): {}", testTableEntity1.hashCode());

        //验证TestStaticPrivateNonVoid1.test1方法应调用了一次
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(1));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,
                argCaptor1.capture(), argCaptor2.capture());

        //检查TestStaticPrivateNonVoid1.test1方法在调用时的参数与预期是否一致
        logger.info("argCaptor1.getValue(): {}", argCaptor1.getValue());
        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue());

        logger.info("argCaptor2.getValue(): {}, argCaptor2.getValue().hashCode(): {}", argCaptor2.getValue(),
                argCaptor2.getValue().hashCode());
        //参数2 TestTableEntity对象的flag应为TestConstants.FLAG1
        Assert.assertEquals(TestConstants.FLAG1, argCaptor2.getValue().getFlag());
        //参数2 TestTableEntity对象的id应为null
        Assert.assertNull(argCaptor2.getValue().getId());
        //参数2 TestTableEntity对象应与之前创建的TestTableEntity对象为同一个实例
        Assert.assertEquals(testTableEntity1.hashCode(), argCaptor2.getValue().hashCode());

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

}
