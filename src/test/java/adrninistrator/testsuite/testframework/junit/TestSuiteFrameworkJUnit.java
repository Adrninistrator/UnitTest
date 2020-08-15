package adrninistrator.testsuite.testframework.junit;

import adrninistrator.test.testframework.junit.TestJUnit1;
import adrninistrator.test.testframework.junit.TestJUnit2;
import adrninistrator.test.testframework.junit.annotation.TestJUnitAnnotationOrder;
import adrninistrator.test.testframework.junit.annotation.TestJUnitAnnotationTimes;
import adrninistrator.test.testframework.junit.annotation.TestJUnitChild1;
import adrninistrator.test.testframework.junit.annotation.TestJUnitChild2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// 运行Suite类时，将运行所有套件类中的所有测试
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
