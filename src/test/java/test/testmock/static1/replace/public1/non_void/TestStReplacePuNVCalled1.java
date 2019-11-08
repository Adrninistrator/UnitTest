package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVCalled1 extends TestMockNoSpBase {

    @Test
    public void test() {

        TestInvocationHandler2 testInvocationHandler2 = new TestInvocationHandler2();

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)
        ).with(testInvocationHandler2);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        Assert.assertEquals(TestConstants.MOCKED, str);
        Assert.assertFalse(testInvocationHandler2.isCalled());

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        Assert.assertEquals(TestConstants.MOCKED, str);
        Assert.assertTrue(testInvocationHandler2.isCalled());
    }
}
