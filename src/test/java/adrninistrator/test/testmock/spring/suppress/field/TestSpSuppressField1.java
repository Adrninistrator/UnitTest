package adrninistrator.test.testmock.spring.suppress.field;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceC1;
import com.adrninistrator.service.impl.TestServiceB1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

// Suppress属性
@PrepareForTest({TestServiceB1Impl.class})
public class TestSpSuppressField1 extends TestSpStubBase {

    @Autowired
    private TestServiceC1 testServiceC1;

    @Test
    public void test1() {
        PowerMockito.suppress(PowerMockito.field(TestServiceB1Impl.class, "testServiceA1"));

        // 通过反射获取testServiceB1中的testServiceA1对象非空
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, "testServiceA1");
        assertNotNull(testServiceA1InB1);

        // 由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testServiceB1.test1("")
        );
    }

    @Test
    public void test2() {
        PowerMockito.suppress(PowerMockito.field(TestServiceB1Impl.class, "testServiceA1"));

        // 由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceC1的方法间接使用时会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testServiceC1.test1("")
        );
    }
}
