package adrninistrator.test.testmock.base;

import adrninistrator.test.common.TestCommonUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*", "javax.crypto.*"})
public abstract class TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMockNoSpBase.class);

    @Before
    public void initTestMockNoSpBase() {
        logger.info("### start {}", this.getClass().getName());

        // 提前获取Mockito与PowerMock版本
        TestCommonUtil.isMockitoNew();
        TestCommonUtil.isPowerMockNew();
    }
}
