package adrninistrator.test.testframework.spring.base;

import com.adrninistrator.applicationlistener.TestApplicationListener;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public abstract class TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringBase.class);

    @Autowired
    private TestApplicationListener testApplicationListener;

    @Before
    public void initTestSpringBase() {
        logger.info("### start {}", this.getClass().getName());
        logger.info("### Spring refresh event hashCode: {}", testApplicationListener.getRefreshEventHashCode());
    }
}
