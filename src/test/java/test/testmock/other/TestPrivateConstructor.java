package test.testmock.other;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockNoSpBase;

public class TestPrivateConstructor extends TestMockNoSpBase {

    @Test
    public void test() {

        TestConstants testConstants1 = Whitebox.newInstance(TestConstants.class);

        Assert.assertNotNull(testConstants1);
        Assert.assertTrue(testConstants1 instanceof TestConstants);

        TestConstants testConstants2 = Whitebox.newInstance(TestConstants.class);

        Assert.assertNotNull(testConstants2);
        Assert.assertTrue(testConstants2 instanceof TestConstants);

        TestCommonUtil.compareObj(testConstants1, testConstants2, false);
    }
}
