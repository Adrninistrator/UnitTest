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
    测试数据库操作是否回滚
    类级别使用@Rollback注解，指定需要回滚
 */
@Rollback
public class TestDBRB_CY2 extends TestDbRollbackBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {

        String id = TestIdGen.genId();
        TestTableEntity testTableEntity1 = TestDbEntityGen.genEntity1(id, TestConstants.FLAG1);

        // 执行插入
        int row = testTableMapper.insert(testTableEntity1);
        assertEquals(1, row);
    }
}
