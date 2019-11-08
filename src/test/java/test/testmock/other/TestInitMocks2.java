package test.testmock.other;

import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceC1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestInitMocks2 extends TestMockBase {

    //@InjectMocks注解需要使用实现类，不能使用接口
    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceA1 testServiceA1Mock;

    /*
        若使用了@PrepareForTest注解，在执行MockitoAnnotations.initMocks方法前，@InjectMocks、@Mock注解对应的对象为空
        在执行MockitoAnnotations.initMocks方法后，@InjectMocks、@Mock注解对应的对象变为非空
     */
    @Before
    public void init() {

        Assert.assertNull(testServiceC1Impl);

        Assert.assertNull(testServiceA1Mock);

        MockitoAnnotations.initMocks(this);

        Assert.assertNotNull(testServiceC1Impl);

        Assert.assertNotNull(testServiceA1Mock);
    }

    @Test
    public void test() {

        TestServiceA1 testServiceA1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceA1.class);

        Assert.assertNotNull(testServiceA1InC1);
    }
}
