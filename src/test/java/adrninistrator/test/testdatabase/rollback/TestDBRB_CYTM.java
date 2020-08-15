package adrninistrator.test.testdatabase.rollback;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import adrninistrator.test.testdatabase.TestDbEntityGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/*
    测试数据库操作是否回滚
    类级别不使用@Rollback注解
    类级别不使用@Transactional注解，使用了以上注解的@Test方法会回滚，未使用以上注解的@Test方法不会使用事务
 */
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class TestDBRB_CYTM extends TestDbBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Transactional
    @Test
    public void testWithTx() {
        doTest();
    }

    @Test
    public void testWithOutTx() {
        doTest();
    }

    private void doTest() {
        String id = TestIdGen.genId();
        TestTableEntity testTableEntity1 = TestDbEntityGen.genEntity1(id, TestConstants.FLAG1);

        // 执行插入
        int row = testTableMapper.insert(testTableEntity1);
        assertEquals(1, row);
    }
}
