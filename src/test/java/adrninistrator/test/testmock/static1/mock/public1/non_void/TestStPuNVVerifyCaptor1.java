package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPuNVVerifyCaptor1 extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVVerifyCaptor1.class);

    @Test
    public void test() {
        // 创建两个ArgumentCaptor，分别对应TestStaticPublicNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2 = ArgumentCaptor.forClass(TestTableEntity.class);

        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);
        testTableEntity1.setId(null);
        logger.info("testTableEntity1.hashCode(): {}", testTableEntity1.hashCode());

        // 调用TestStaticPublicNonVoid1.test1方法
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 验证TestStaticPublicNonVoid1.test1方法应调用了一次
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(argCaptor1.capture(), argCaptor2.capture());

        check(argCaptor1, argCaptor2, testTableEntity1);
    }

    private void check(ArgumentCaptor<String> argCaptor1, ArgumentCaptor<TestTableEntity> argCaptor2, TestTableEntity
            testTableEntity1) {
        // 检查TestStaticPublicNonVoid1.test1方法在调用时的参数与预期是否一致
        logger.info("argCaptor1.getValue(): {}", argCaptor1.getValue());
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue());

        logger.info("argCaptor2.getValue(): {}, argCaptor2.getValue().hashCode(): {}", argCaptor2.getValue(),
                argCaptor2.getValue().hashCode());
        // 参数2 TestTableEntity对象应与之前创建的TestTableEntity对象为同一个实例
        assertEquals(testTableEntity1.hashCode(), argCaptor2.getValue().hashCode());

        List<String> arg1List = argCaptor1.getAllValues();
        assertEquals(1, arg1List.size());
        assertEquals(TestConstants.FLAG1, arg1List.get(0));

        List<TestTableEntity> arg2List = argCaptor2.getAllValues();
        assertEquals(1, arg2List.size());
        assertEquals(testTableEntity1.hashCode(), arg2List.get(0).hashCode());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
