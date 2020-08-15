package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestTxService1;
import com.adrninistrator.service.impl.TestTxService1Impl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

// 查看使用了事务的类的信息
public class TestDatabaseTxInfo extends TestDbBase {

    private static final Logger logger = LoggerFactory.getLogger(TestDatabaseTxInfo.class);

    @Autowired
    private TestTxService1 testTxService1;

    @Before
    public void init() {
        assertNotEquals(TestTxService1Impl.class, testTxService1.getClass());
        logger.info("testTxService1 class name: {}", testTxService1.getClass().getName());
    }

    @Test
    public void test1() {
        String id = TestIdGen.genId();

        testTxService1.withTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    @Test
    public void test2() {
        String id = TestIdGen.genId();

        testTxService1.withOutTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }
}
