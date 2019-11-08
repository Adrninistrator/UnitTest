package testsuite.testframework.spring;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.testframework.spring.test.TestSpring1;
import test.testframework.spring.test.TestSpring2;
import test.testframework.spring.test.TestSpring3;
import test.testframework.spring.test.TestSpring4;

//运行Suite类时，将运行所有套件类中的所有测试
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        TestSpring1.class,
        TestSpring2.class,
        TestSpring3.class,
        TestSpring4.class
})
public class TestSuiteFrameworkSpring {
}
