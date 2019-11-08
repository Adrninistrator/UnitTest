package test.testmock.spring.suppress.other;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceB1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

@PrepareForTest({TestServiceB1Impl.class})
public abstract class TestSpSuppressOtherBase extends TestSpStubBase {

    @Before
    public void init() {

        doInit();
    }

    @Test
    public void test() {

        String str = testServiceA1.test1("");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        Assert.assertNull(str);
    }

    protected abstract void doInit();
}
