package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceC1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// 测试MockitoAnnotations.initMocks()方法
@PrepareForTest({})
public class TestInitMocksWithPrepare2 extends TestMockBase {

    // @InjectMocks注解需要使用实现类，不能使用接口
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
        assertNull(testServiceC1Impl);

        assertNull(testServiceA1Mock);

        MockitoAnnotations.initMocks(this);

        assertNotNull(testServiceC1Impl);

        assertNotNull(testServiceA1Mock);
    }

    @Test
    public void test() {
    }
}
