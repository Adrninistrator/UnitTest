package test.testframework.junit.annotation.parent;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class TestJUnitParent3 {

    protected int value = 0;

    @Before
    public void init() {

        Assert.assertEquals(0, value);
    }

    @Test
    public void testParent() {

        Assert.assertEquals(TestConstants.DEFAULT_INT, value);
    }
}
