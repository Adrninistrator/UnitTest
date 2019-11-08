package test.testmock.spring.spy.compare;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//创建Spy对象，使用@Spy注解
public class TestSpSpyAnnotation extends TestMockBase {

    //使用@Spy注解时，需要创建新的对象
    @Spy
    private TestPublicNonVoidService1 testPublicNonVoidService1AtSpy1 = new TestPublicNonVoidService1Impl();

    @Spy
    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1AtSpy2;

    //对@Spy指定的通过new创建的对象，可执行真实方法，但被注入的对象为空
    @Test
    public void test1() {

        //@Spy指定的通过new创建的对象的被注入对象为空
        TestTableMapper testTableMapper = Whitebox.getInternalState(testPublicNonVoidService1AtSpy1, TestTableMapper
                .class);
        Assert.assertNull(testTableMapper);

        //执行真实方法，由于testTableMapper对象为空，会出现空指针异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        testPublicNonVoidService1AtSpy1.test2("");
    }

    //@Spy与@Autowired注解支持同时使用
    @Test
    public void test2() {

        //Mockito.spy返回对象的被注入对象非空
        TestTableMapper testTableMapper = Whitebox.getInternalState(testPublicNonVoidService1AtSpy2, TestTableMapper
                .class);
        Assert.assertNotNull(testTableMapper);

        String str = testPublicNonVoidService1AtSpy2.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1AtSpy2).test2(Mockito.anyString());

        str = testPublicNonVoidService1AtSpy2.test2("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
