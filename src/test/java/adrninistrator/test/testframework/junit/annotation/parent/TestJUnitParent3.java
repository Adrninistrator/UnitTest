package adrninistrator.test.testframework.junit.annotation.parent;

import com.adrninistrator.common.constants.TestConstants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class TestJUnitParent3 {

    protected int value = 0;

    @Before
    public void init() {
        assertEquals(0, value);
    }

    @Test
    public void testParent() {
        assertEquals(TestConstants.DEFAULT_INT, value);
    }
}
