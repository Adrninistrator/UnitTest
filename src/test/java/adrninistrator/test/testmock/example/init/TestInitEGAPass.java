package adrninistrator.test.testmock.example.init;

import adrninistrator.test.common.TestInitInterface;
import adrninistrator.test.testmock.example.base.TestEGCommon;
import com.adrninistrator.service.impl.example.TestServiceEG1Impl;
import org.powermock.api.mockito.PowerMockito;

// 修改TestServiceEG1Impl.checkA()方法不通过检查
public class TestInitEGAPass implements TestInitInterface {

    @Override
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestServiceEG1Impl.class, TestEGCommon.NAME_CHECKA)).toReturn(true);
    }
}