package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceC1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 测试@InjectMocks注解
public class TestInjectMocks3 extends TestMockBase {

    // @InjectMocks注解需要指定实现类对象，不能指定接口对象
    @InjectMocks
    private TestServiceC1Impl testServiceC1Impl;

    @Autowired
    private TestServiceB1 testServiceB1Mock;

    @Autowired
    private TestServiceA1 testServiceA1Mock;

    @Before
    public void init() {
        // 使用@InjectMocks注解指定的生成的对象为原始类的对象，不是Mock/Spy对象
        assertEquals(TestServiceC1Impl.class, testServiceC1Impl.getClass());

        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceB1.class);
        TestServiceA1 testServiceA1InC1 = Whitebox.getInternalState(testServiceC1Impl, TestServiceA1.class);

        // 未通过@Mock/@Spy注解指定TestServiceB1对象，因此TestServiceC1Impl对象中的TestServiceB1对象为空
        assertNull(testServiceB1InC1);

        // 未通过@Mock/@Spy注解指定TestServiceA1对象，因此TestServiceC1Impl对象中的TestServiceA1对象为空
        assertNull(testServiceA1InC1);
    }

    @Test
    public void test() {
    }
}
