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

import static org.junit.Assert.assertNotNull;

// 测试MockitoAnnotations.initMocks()方法
public class TestInitMocksNoPrepare extends TestMockBase {

    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceA1 testServiceA1Mock;

    @Spy
    private TestServiceB1 testServiceB1Spy = new TestServiceB1Impl();

    // 未使用@PrepareForTest注解，不会导致@InjectMocks、@Mock注解对应的对象为空
    @Before
    public void init() {
        assertNotNull(testServiceC1Impl);

        assertNotNull(testServiceA1Mock);

        assertNotNull(testServiceB1Spy);
    }

    @Test
    public void test() {
    }
}
