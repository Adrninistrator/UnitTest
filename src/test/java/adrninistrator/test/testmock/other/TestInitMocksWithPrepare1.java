package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceB1Impl;
import com.adrninistrator.service.impl.TestServiceC1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// 测试MockitoAnnotations.initMocks()方法
@PrepareForTest({})
public class TestInitMocksWithPrepare1 extends TestMockBase {

    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceA1 testServiceA1Mock;

    @Spy
    private TestServiceB1 testServiceB1Spy = new TestServiceB1Impl();

    // 若使用了@PrepareForTest注解，且未执行MockitoAnnotations.initMocks方法，会导致@InjectMocks、@Mock注解对应的对象为空，不影响@Spy注解对应的对象
    @Before
    public void init() {
        assertNull(testServiceC1Impl);

        assertNull(testServiceA1Mock);

        assertNotNull(testServiceB1Spy);
    }

    @Test
    public void test() {
    }
}
