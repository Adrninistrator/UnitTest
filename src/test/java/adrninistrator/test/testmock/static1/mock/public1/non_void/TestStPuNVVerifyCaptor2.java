package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPuNVVerifyCaptor2 extends TestStaticPublicNonVoidBase {

    @Test
    public void test() {
        // 创建两个ArgumentCaptor，分别对应TestStaticPublicNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1a = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2a = ArgumentCaptor.forClass(TestTableEntity.class);

        // 执行第1次
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, null);

        // 验证TestStaticPublicNonVoid1.test1方法应调用了1次
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(argCaptor1a.capture(), argCaptor2a.capture());

        // 创建两个ArgumentCaptor，分别对应TestStaticPublicNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1b = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2b = ArgumentCaptor.forClass(TestTableEntity.class);

        check1(argCaptor1a, argCaptor2a);

        // 执行第2次
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, null);

        // 验证TestStaticPublicNonVoid1.test1方法应调用了2次
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(2));
        TestStaticPublicNonVoid1.test1(argCaptor1b.capture(), argCaptor2b.capture());

        check2(argCaptor1b, argCaptor2b);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    private void check1(ArgumentCaptor<String> argCaptor1, ArgumentCaptor<TestTableEntity> argCaptor2) {
        // 最后一次调用的参数1应为TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue());
        // 最后一次调用的参数2应为null
        assertNull(argCaptor2.getValue());

        // 返回的列表元素数量与方法调用的次数相同，
        List<String> arg1List = argCaptor1.getAllValues();
        assertEquals(1, arg1List.size());
        assertEquals(TestConstants.FLAG1, arg1List.get(0));

        List<TestTableEntity> arg2List = argCaptor2.getAllValues();
        assertEquals(1, arg2List.size());
        assertNull(arg2List.get(0));
    }

    private void check2(ArgumentCaptor<String> argCaptor1, ArgumentCaptor<TestTableEntity> argCaptor2) {
        // 最后一次调用的参数1应为TestConstants.FLAG2
        assertEquals(TestConstants.FLAG2, argCaptor1.getValue());
        // 最后一次调用的参数2应为null
        assertNull(argCaptor2.getValue());

        // 返回的列表元素数量与方法调用的次数相同，每次调用方法的参数在列表中的序号递增
        List<String> arg1List = argCaptor1.getAllValues();
        assertEquals(2, arg1List.size());
        assertEquals(TestConstants.FLAG1, arg1List.get(0));
        assertEquals(TestConstants.FLAG2, arg1List.get(1));

        List<TestTableEntity> arg2List = argCaptor2.getAllValues();
        assertEquals(2, arg2List.size());
        assertNull(arg2List.get(0));
        assertNull(arg2List.get(1));
    }
}
