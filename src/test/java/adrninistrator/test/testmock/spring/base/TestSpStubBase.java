package adrninistrator.test.testmock.spring.base;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Before;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public abstract class TestSpStubBase extends TestMockBase {

    @Autowired
    protected TestServiceA1 testServiceA1;

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Before
    public void init() throws Exception {

        String str = testServiceA1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        StringBuilder stringBuilder = new StringBuilder();
        testServiceA1.test2(stringBuilder);
        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST3, "");
        assertEquals(TestConstants.NOT_MOCKED, str);

        stringBuilder.setLength(0);
        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST4, stringBuilder);
        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        str = testServiceB1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        stringBuilder.setLength(0);
        testServiceB1.test2(stringBuilder);
        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }
}
