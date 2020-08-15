package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.TestService2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 替换AOP原始对象中的变量为Mock对象
public class TestSpAOPMRawMockMem1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Autowired
    private TestAOPService1 testAOPService2;

    @Before
    public void init() {
        String str = testAOPService2.test2("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {
        TestService2 testService2Mock = Mockito.mock(TestService2.class);
        Mockito.when(testService2Mock.test1(TestConstants.FLAG3)).thenReturn(TestConstants.MOCKED);

        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAOPService1 testAOPService1Raw = AopTestUtils.getTargetObject(testAOPService1);

        Whitebox.setInternalState(testAOPService1Raw, testService2Mock);

        // 直接调用AOP代理对象的方法，会调用成员变量被替换的Mock对象对应的方法
        String str = testAOPService1.test2(TestConstants.FLAG3);
        assertEquals(TestConstants.MOCKED, str);

        // 间接调用AOP代理对象的方法，会调用成员变量被替换的Mock对象对应的方法
        str = testAOPService2.test2(TestConstants.FLAG3);
        assertEquals(TestConstants.MOCKED, str);

        // 间接调用AOP代理对象的方法，会调用成员变量被替换的Mock对象对应的方法，不满足Stub条件，返回null
        str = testAOPService2.test2("");
        assertNull(str);
    }
}
