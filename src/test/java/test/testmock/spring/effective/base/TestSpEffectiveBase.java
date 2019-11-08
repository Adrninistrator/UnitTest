package test.testmock.spring.effective.base;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

import java.io.FileNotFoundException;

@PrepareForTest({TestServiceA1Impl.class})
public abstract class TestSpEffectiveBase extends TestMockBase {

    @Autowired
    protected TestServiceA1Impl testServiceA1;

    protected TestServiceA1Impl testServiceA1Mock;

    protected TestServiceA1Impl testServiceA1Spy;

    @Before
    public void initTestSpEffectiveBase() {

        testServiceA1Mock = Mockito.mock(TestServiceA1Impl.class);

        testServiceA1Spy = Mockito.spy(testServiceA1);
    }

    protected void stubCommon(Class clazz) {

        PowerMockito.stub(PowerMockito.method(clazz, TestServiceA1Impl.NAME_TEST1)).toReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(clazz, TestServiceA1Impl.NAME_TEST1)).toReturn(TestConstants.FLAG2);

        PowerMockito.stub(PowerMockito.method(clazz, TestServiceA1Impl.NAME_TEST1)).toThrow(new FileNotFoundException
                (TestConstants.FLAG1));

        PowerMockito.replace(PowerMockito.method(clazz, TestServiceA1Impl.NAME_TEST1)).with((proxy, method, args) ->
                TestConstants.FLAG3);
    }

    protected void stubCommon2(Class clazz) {

        PowerMockito.suppress(PowerMockito.method(clazz, TestServiceA1Impl.NAME_TEST1));

        stubCommon(clazz);
    }
}
