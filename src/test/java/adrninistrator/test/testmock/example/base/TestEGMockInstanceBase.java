package adrninistrator.test.testmock.example.base;

import adrninistrator.test.common.TestInitAnnotation;
import adrninistrator.test.common.TestReplaceUtil;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.example.init.TestInitEGAPass;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.example.TestServiceEG2;
import com.adrninistrator.service.example.TestServiceEG3;
import com.adrninistrator.service.example.TestServiceEG4;
import com.adrninistrator.service.impl.example.TestServiceEG1Impl;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

// 对指定的Mock/Spy对象的非静态方法进行Mock，基类

// 通过@TestInitAnnotation注解指定TestInitEGAPass.class，使testServiceEG4.test()方法执行TestServiceEG1Impl.checkA()方法时通过检查
@TestInitAnnotation({TestInitEGAPass.class})
@PrepareForTest({TestServiceEG1Impl.class})
public abstract class TestEGMockInstanceBase extends TestMockBase {

    @Autowired
    protected TestServiceEG4 testServiceEG4;

    @Before
    public void initTestEGMockBase() {
        TestServiceEG2 testServiceEG2Mock = TestReplaceUtil.replaceMockMember(testServiceEG4, TestServiceEG2.class);

        // 修改testServiceEG4中被替换的TestServiceEG2Impl实例的checkB()方法返回chooseCheckB()方法的返回值
        Mockito.when(testServiceEG2Mock.checkB(Mockito.anyString())).thenReturn(chooseCheckB());

        TestServiceEG3 testServiceEG3Spy = TestReplaceUtil.replaceSpyMember(testServiceEG4, TestServiceEG3.class);

        // 修改testServiceEG4中被替换的TestServiceEG3Impl实例的checkC()方法返回chooseCheckC()方法的返回值
        Mockito.doReturn(chooseCheckC()).when(testServiceEG3Spy).checkC(Mockito.anyString());
    }

    protected String chooseCheckB() {
        return TestConstants.FLAG1;
    }

    protected abstract String chooseCheckC();
}
