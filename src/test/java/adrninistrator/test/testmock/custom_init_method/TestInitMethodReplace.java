package adrninistrator.test.testmock.custom_init_method;

import adrninistrator.test.common.TestInitAnnotation;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.custom_init_method.init_method.TestInitReplace;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*
    使用自定义注解@TestInitAnnotation执行指定的初始化操作，Replace
 */
@TestInitAnnotation({TestInitReplace.class})
@PrepareForTest({TestStaticPublicNonVoid1.class, TestPublicNonVoidService1Impl.class})
public class TestInitMethodReplace extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
