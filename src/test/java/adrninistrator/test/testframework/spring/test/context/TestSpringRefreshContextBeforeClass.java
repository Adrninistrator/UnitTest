package adrninistrator.test.testframework.spring.test.context;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import com.adrninistrator.service.TestService2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

// 使Spring Context重新加载，在执行类之前
@DirtiesContext(classMode = BEFORE_CLASS)
public class TestSpringRefreshContextBeforeClass extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringRefreshContextBeforeClass.class);

    @Autowired
    private TestService2 testService2;

    private static int lastHashCode = 0;

    @Test
    public void test1() {
        doTest("test1");
    }

    @Test
    public void test2() {
        doTest("test2");
    }

    @Test
    public void test3() {
        doTest("test3");
    }

    private void doTest(String methodName) {
        int hashCode = System.identityHashCode(testService2);

        logger.info("{} testService2 hashCode: {}", methodName, hashCode);

        if (lastHashCode != 0) {
            assertEquals(lastHashCode, hashCode);
        }

        lastHashCode = hashCode;
    }
}
