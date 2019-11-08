package test.testmock.other;

import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceB1Impl;
import com.test.service.impl.TestServiceC1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestInitMocks1 extends TestMockBase {

    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceA1 testServiceA1Mock;

    @Spy
    private TestServiceB1 testServiceB1Spy = new TestServiceB1Impl();

    //若使用了@PrepareForTest注解，且未执行MockitoAnnotations.initMocks方法，会导致@InjectMocks、@Mock注解对应的对象为空
    @Before
    public void init() {

        Assert.assertNull(testServiceC1Impl);

        Assert.assertNull(testServiceA1Mock);

        Assert.assertNotNull(testServiceB1Spy);
    }

    @Test
    public void test() {
    }
}
