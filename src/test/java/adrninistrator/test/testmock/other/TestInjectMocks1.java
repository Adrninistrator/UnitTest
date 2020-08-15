package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceC1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 测试@InjectMocks注解
public class TestInjectMocks1 extends TestMockBase {

    // @InjectMocks注解需要指定实现类对象，不能指定接口对象
    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Mock
    private TestServiceB1 testServiceB1Mock;

    @Mock
    private TestServiceA1 testServiceA1Mock;

    @Before
    public void init() {
        // 使用@InjectMocks注解指定的生成的对象为原始类的对象，不是Mock/Spy对象
        assertEquals(TestServiceC1Impl.class, testServiceC1Impl.getClass());

        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceB1.class);
        TestServiceA1 testServiceA1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceA1.class);

        // TestServiceC1Impl对象指定了@InjectMocks注解，使用了@Mock注解的TestServiceB1对象被注入，因此TestServiceC1Impl对象中的TestServiceB1对象非空
        assertNotNull(testServiceB1InC1);

        // TestServiceC1Impl对象指定了@InjectMocks注解，使用了@Mock注解的testServiceA1对象被注入，因此TestServiceC1Impl对象中的TestServiceA1对象非空
        assertNotNull(testServiceA1InC1);
    }

    @Test
    public void test() {
    }
}
