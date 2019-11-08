package test.testmock.spring.effective.nomock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

import java.io.FileNotFoundException;

//PowerMockito.stub().toThrow()执行多次的生效情况
public class TestSpEffectiveStubToThrow1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toThrow(new FileNotFoundException(TestConstants.FLAG2));

        //最后一次PowerMockito.stub生效
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.FLAG2);

        testServiceA1.test1("");
    }
}
