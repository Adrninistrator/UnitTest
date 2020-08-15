package adrninistrator.test.testmock.example.base;

import adrninistrator.test.common.TestInitAnnotation;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.example.init.TestInitEGAPass;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.example.TestServiceEG4;
import com.adrninistrator.service.impl.example.TestServiceEG1Impl;
import com.adrninistrator.service.impl.example.TestServiceEG2Impl;
import com.adrninistrator.service.impl.example.TestServiceEG3Impl;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

// 对指定类的全部实例的非静态方法进行Mock，基类

// 通过@TestInitAnnotation注解指定TestInitEGAPass.class，使testServiceEG4.test()方法执行TestServiceEG1Impl.checkA()方法时通过检查
@TestInitAnnotation({TestInitEGAPass.class})
@PrepareForTest({TestServiceEG1Impl.class, TestServiceEG2Impl.class, TestServiceEG3Impl.class})
public abstract class TestEGMockClassBase extends TestMockBase {

    @Autowired
    protected TestServiceEG4 testServiceEG4;

    @Before
    public void initTestEGMockBase() {
        // 修改TestServiceEG2Impl.checkB()方法返回chooseCheckB()方法的返回值
        PowerMockito.stub(PowerMockito.method(TestServiceEG2Impl.class, TestEGCommon.NAME_CHECKB)).toReturn
                (chooseCheckB());

        // 修改TestServiceEG3Impl.checkC()方法返回chooseCheckC()方法的返回值
        PowerMockito.replace(PowerMockito.method(TestServiceEG3Impl.class, TestEGCommon.NAME_CHECKC)).with(
                (proxy, method, args) -> chooseCheckC());
    }

    protected String chooseCheckB() {
        return TestConstants.FLAG1;
    }

    protected abstract String chooseCheckC();
}
