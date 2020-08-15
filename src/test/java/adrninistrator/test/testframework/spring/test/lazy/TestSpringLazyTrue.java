package adrninistrator.test.testframework.spring.test.lazy;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import com.adrninistrator.common.constants.TestFlag;
import com.adrninistrator.service.impl.TestServiceLazyFalseImpl;
import com.adrninistrator.service.impl.TestServiceLazyTrueImpl;
import com.adrninistrator.spring.TestBeanPostProcessor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

// 将所有的Bean设置为懒加载

// 使Spring Context重新加载，在执行类之前
@DirtiesContext(classMode = BEFORE_CLASS)
public class TestSpringLazyTrue extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringLazyTrue.class);

    @BeforeClass
    public static void beforeClass() {
        // 设置TestFlag标志为懒加载
        TestFlag.setAllLazy(Boolean.TRUE);
    }

    @Test
    public void test() {
        // 通过@Lazy注解指定懒加载的类TestServiceLazyTrueImpl未完成实例化
        assertFalse(TestServiceLazyTrueImpl.isInited());

        // 通过@Lazy注解指定非懒加载的类TestServiceLazyFalseImpl未完成实例化
        assertFalse(TestServiceLazyFalseImpl.isInited());

        logger.info("initedNum: {}", TestBeanPostProcessor.getInitedNum());
    }
}
