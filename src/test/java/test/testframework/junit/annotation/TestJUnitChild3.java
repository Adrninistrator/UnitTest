package test.testframework.junit.annotation;

import com.test.common.TestConstants;
import org.junit.Before;
import test.testframework.junit.annotation.parent.TestJUnitParent3;

//@Test注解可以只出现在超类中，不出现在子类中
public class TestJUnitChild3 extends TestJUnitParent3 {

    @Before
    public void before() {

        value = TestConstants.DEFAULT_INT;
    }
}
