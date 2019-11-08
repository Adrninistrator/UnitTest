package test.testmock.spring.suppress.field;

import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceB1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.base.TestSpStubBase;

//Suppress属性
@PrepareForTest({TestServiceB1Impl.class})
public class TestSpSuppressField2 extends TestSpStubBase {

    @Test
    public void test() {

        SuppressCode.suppressField(PowerMockito.field(TestServiceB1Impl.class, "testServiceA1"));

        //通过反射获取testServiceB1中的testServiceA1对象非空
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, "testServiceA1");
        Assert.assertNotNull(testServiceA1InB1);

        //由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        testServiceB1.test1("");
    }
}
