package test.testdatabase;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestTxService1;
import com.test.service.impl.TestTxService1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.atomic.AtomicInteger;

//查看使用了事务的类的信息
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDatabaseTxInfo {

    private static final Logger logger = LoggerFactory.getLogger(TestDatabaseTxInfo.class);

    @Autowired
    private TestTxService1 testTxService1;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Before
    public void init() {

        Assert.assertNotEquals(TestTxService1Impl.class.getName(), testTxService1.getClass().getName());
        logger.info("testTxService1 class name: {}", testTxService1.getClass().getName());
    }

    @Test
    public void test1() {

        String id = genId();

        testTxService1.withTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    @Test
    public void test2() {

        String id = genId();

        testTxService1.withOutTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    private String genId() {

        String id = System.currentTimeMillis() + TestConstants.MINUS + atomicInteger.incrementAndGet();

        logger.info("genId: {}", id);

        return id;
    }
}
