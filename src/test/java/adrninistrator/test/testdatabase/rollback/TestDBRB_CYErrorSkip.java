package adrninistrator.test.testdatabase.rollback;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import adrninistrator.test.testdatabase.TestDbEntityGen;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestErrorSkipExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*
    测试数据库操作是否回滚
    使用基于TransactionalTestExecutionListener修改的测试执行监听器TransactionalTestErrorSkipExecutionListener
    未出现异常时回滚，出现异常时不回滚
 */
@TestExecutionListeners({TransactionalTestErrorSkipExecutionListener.class})
@Transactional
public class TestDBRB_CYErrorSkip extends TestDbBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void testError() {

        doTest("error");

        fail();
    }

    @Test
    public void testNormal() {

        doTest("normal");
    }

    private void doTest(String flag) {

        String id = TestIdGen.genId();
        TestTableEntity testTableEntity1 = TestDbEntityGen.genEntity1(id, flag);

        // 执行插入
        int row = testTableMapper.insert(testTableEntity1);
        assertEquals(1, row);
    }
}
