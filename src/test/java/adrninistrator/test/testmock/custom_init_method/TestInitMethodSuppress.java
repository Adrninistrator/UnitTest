package adrninistrator.test.testmock.custom_init_method;

import adrninistrator.test.common.TestInitAnnotation;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.custom_init_method.init_method.TestInitSuppress;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceB1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

/*
    使用自定义注解@TestInitAnnotation执行指定的初始化操作，Suppress
 */
@TestInitAnnotation({TestInitSuppress.class})
@PrepareForTest({TestStaticPublicNonVoid1.class, TestServiceB1Impl.class})
public class TestInitMethodSuppress extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.getFlag();
        assertNull(str);
    }

    @Test
    public void test2() {
        // 由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testServiceB1.test2(null)
        );
    }

    @Test
    public void test3() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertNull(str);
    }

    @Test
    public void test4() {
        String str = testServiceB1.test1("");
        assertNull(str);
    }
}
