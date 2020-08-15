package adrninistrator.testsuite.testframework.spring;

import adrninistrator.test.testframework.spring.test.context.TestSpringRefreshContextBeforeClass;
import adrninistrator.test.testframework.spring.test.context.TestSpringRefreshContextBeforeMethod;
import adrninistrator.test.testframework.spring.test.context.TestSpringReuseContext1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// 运行Suite类时，将运行所有套件类中的所有测试
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        TestSpringReuseContext1.class,
        TestSpringRefreshContextBeforeClass.class,
        TestSpringRefreshContextBeforeMethod.class
})
public class TestSuiteFrameworkSpring {
}
