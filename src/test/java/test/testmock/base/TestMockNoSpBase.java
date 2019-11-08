package test.testmock.base;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.common.TestCommonUtil;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*", "javax.crypto.*"})
public abstract class TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMockNoSpBase.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initTestMockNoSpBase() {

        logger.info("### start {}", this.getClass().getName());

        //提前获取Mockito与PowerMock版本
        TestCommonUtil.isMockitoNew();
        TestCommonUtil.isPowerMockNewest();
    }
}
