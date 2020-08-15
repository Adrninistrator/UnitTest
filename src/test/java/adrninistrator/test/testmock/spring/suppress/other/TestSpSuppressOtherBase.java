package adrninistrator.test.testmock.spring.suppress.other;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceB1Impl;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@PrepareForTest({TestServiceB1Impl.class})
public abstract class TestSpSuppressOtherBase extends TestSpStubBase {

    @Before
    public void init() {
        doInit();
    }

    @Test
    public void test() {
        String str = testServiceA1.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        assertNull(str);
    }

    protected abstract void doInit();
}
