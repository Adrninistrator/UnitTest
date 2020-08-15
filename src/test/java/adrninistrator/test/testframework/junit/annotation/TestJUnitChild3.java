package adrninistrator.test.testframework.junit.annotation;

import adrninistrator.test.testframework.junit.annotation.parent.TestJUnitParent3;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Before;

// @Test注解可以只出现在超类中，不出现在子类中
public class TestJUnitChild3 extends TestJUnitParent3 {

    @Before
    public void before() {
        value = TestConstants.DEFAULT_INT;
    }
}
