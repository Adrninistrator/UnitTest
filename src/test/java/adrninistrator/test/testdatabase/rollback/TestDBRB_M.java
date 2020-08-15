package adrninistrator.test.testdatabase.rollback;

import adrninistrator.test.base.TestDbRollbackBase;
import adrninistrator.test.common.TestIdGen;
import adrninistrator.test.testdatabase.TestDbEntityGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertEquals;

/*
    测试数据库操作是否回滚，注解添加在方法级别
 */
public class TestDBRB_M extends TestDbRollbackBase {

    @Autowired
    private TestTableMapper testTableMapper;

    // 测试数据库操作是否回滚，方法级别不使用@Rollback注解，会回滚
    @Test
    public void testRollback1() {
        doTest();
    }

    // 测试数据库操作是否回滚，方法级别使用@Rollback注解，指定需要回滚
    @Rollback
    @Test
    public void testRollback2() {
        doTest();
    }

    // 测试数据库操作是否回滚，方法级别使用@Rollback注解，指定不需要回滚
    @Rollback(false)
    @Test
    public void testNoRollback() {
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
