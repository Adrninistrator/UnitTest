package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestStPuNVVerifyCaptor2 extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVVerifyCaptor2.class);

    @Test
    public void test() {

        //创建两个ArgumentCaptor，分别对应TestStaticPublicNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1a = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2a = ArgumentCaptor.forClass(TestTableEntity.class);

        //执行第1次
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, null);

        //验证TestStaticPublicNonVoid1.test1方法应调用了1次
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(argCaptor1a.capture(), argCaptor2a.capture());

        //创建两个ArgumentCaptor，分别对应TestStaticPublicNonVoid1.test1方法的参数1与参数2
        ArgumentCaptor<String> argCaptor1b = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TestTableEntity> argCaptor2b = ArgumentCaptor.forClass(TestTableEntity.class);

        check1(argCaptor1a, argCaptor2a);

        //执行第2次
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, null);

        //验证TestStaticPublicNonVoid1.test1方法应调用了2次
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(2));
        TestStaticPublicNonVoid1.test1(argCaptor1b.capture(), argCaptor2b.capture());

        check2(argCaptor1b, argCaptor2b);

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    private void check1(ArgumentCaptor<String> argCaptor1, ArgumentCaptor<TestTableEntity> argCaptor2) {

        //最后一次调用的参数1应为TestConstants.FLAG1
        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue());
        //最后一次调用的参数2应为null
        Assert.assertNull(argCaptor2.getValue());

        //返回的列表元素数量与方法调用的次数相同，
        List<String> arg1List = argCaptor1.getAllValues();
        Assert.assertEquals(1, arg1List.size());
        Assert.assertEquals(TestConstants.FLAG1, arg1List.get(0));

        List<TestTableEntity> arg2List = argCaptor2.getAllValues();
        Assert.assertEquals(1, arg2List.size());
        Assert.assertNull(arg2List.get(0));
    }

    private void check2(ArgumentCaptor<String> argCaptor1, ArgumentCaptor<TestTableEntity> argCaptor2) {

        //最后一次调用的参数1应为TestConstants.FLAG2
        Assert.assertEquals(TestConstants.FLAG2, argCaptor1.getValue());
        //最后一次调用的参数2应为null
        Assert.assertNull(argCaptor2.getValue());

        //返回的列表元素数量与方法调用的次数相同，每次调用方法的参数在列表中的序号递增
        List<String> arg1List = argCaptor1.getAllValues();
        Assert.assertEquals(2, arg1List.size());
        Assert.assertEquals(TestConstants.FLAG1, arg1List.get(0));
        Assert.assertEquals(TestConstants.FLAG2, arg1List.get(1));

        List<TestTableEntity> arg2List = argCaptor2.getAllValues();
        Assert.assertEquals(2, arg2List.size());
        Assert.assertNull(arg2List.get(0));
        Assert.assertNull(arg2List.get(1));
    }
}
