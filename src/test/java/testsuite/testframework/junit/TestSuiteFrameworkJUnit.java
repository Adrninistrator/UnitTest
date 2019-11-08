package testsuite.testframework.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.testframework.junit.TestJUnit1;
import test.testframework.junit.TestJUnit2;
import test.testframework.junit.annotation.TestJUnitAnnotationOrder;
import test.testframework.junit.annotation.TestJUnitAnnotationTimes;
import test.testframework.junit.annotation.TestJUnitChild1;
import test.testframework.junit.annotation.TestJUnitChild2;

//运行Suite类时，将运行所有套件类中的所有测试
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        TestJUnit1.class,
        TestJUnit2.class,
        TestJUnitAnnotationOrder.class,
        TestJUnitAnnotationTimes.class,
        TestJUnitChild1.class,
        TestJUnitChild2.class
})
public class TestSuiteFrameworkJUnit {
}
