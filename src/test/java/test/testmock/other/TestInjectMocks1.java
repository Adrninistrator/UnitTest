package test.testmock.other;

import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceC1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

public class TestInjectMocks1 extends TestMockBase {

    //@InjectMocks注解需要使用实现类，不能使用接口
    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceB1 testServiceB1Mock;

    @Before
    public void init() {

        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceB1.class);

        TestServiceA1 testServiceA1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceA1.class);

        //TestServiceC1Impl对象指定了@InjectMocks注解，使用了@Mock注解的testServiceB1被注入，因此testServiceB1InC1中的TestServiceB1对象非空
        Assert.assertNotNull(testServiceB1InC1);

        //testServiceB1Mock为被注入testServiceC1Impl中的TestServiceB1类的对象
        TestCommonUtil.compareObj(testServiceB1Mock, testServiceB1InC1, true);

        //未通过@Mock注解指定TestServiceA1对象，因此testServiceB1InC1中的TestServiceA1对象非空
        Assert.assertNull(testServiceA1InC1);
    }

    @Test
    public void test() {

        String str = testServiceC1Impl.test1("");

        Assert.assertNull(str);
    }
}
