package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestService2;
import com.test.service.impl.TestAOPService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//替换AOP原始对象中的变量为Mock对象，错误方法
public class TestSpAOPRawMockMemWrong1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test() {

        TestService2 testService2Mock = Mockito.mock(TestService2.class);
        Mockito.when(testService2Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        if (testAOPService1.getClass().getName().contains(TestAOPService1Impl.class.getSimpleName())) {
            //AOP代理对象类名中包含原始类名，说明使用CGLIB代理

            Whitebox.setInternalState(testAOPService1, testService2Mock);

            TestService2 testService2 = Whitebox.getInternalState(testAOPService1, TestService2.class);
            Assert.assertNotNull(testService2);

            String str = testAOPService1.test2("");
            Assert.assertEquals(TestConstants.NOT_MOCKED, str);
        } else {
            //AOP代理对象类名中不包含原始类名，说明使用JDK动态代理

            expectedException.expect(new TestMatcherExpClassEquals(FieldNotFoundException.class));

            Whitebox.setInternalState(testAOPService1, testService2Mock);
        }
    }
}
