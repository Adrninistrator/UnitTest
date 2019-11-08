package test.testmock.other;

import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceB1Impl;
import com.test.service.impl.TestServiceC1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

public class TestInjectMocks2 extends TestMockBase {

    //@InjectMocks注解需要使用实现类，不能使用接口
    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Spy
    private TestServiceB1 testServiceB1 = new TestServiceB1Impl();

    @Before
    public void init() {

        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceB1.class);

        //TestServiceC1Impl对象指定了@InjectMocks注解，使用了@Spy注解的testServiceB1Impl被注入，因此testServiceB1InC1中的TestServiceB1对象非空
        Assert.assertNotNull(testServiceB1InC1);

        //testServiceB1为被注入testServiceC1Impl中的TestServiceB1类的对象
        TestCommonUtil.compareObj(testServiceB1, testServiceB1InC1, true);
    }

    //执行testServiceC1Impl.test1方法，会调用testServiceB1Impl的test1方法，由于testServiceB1Impl中的TestServiceA1对象未完成注入，因此会出现空指针异常
    @Test
    public void test() {

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        testServiceC1Impl.test1("");
    }
}
