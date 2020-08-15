package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 测试数据库基本操作
public class TestDatabase extends TestDbBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {
        TestTableEntity queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        assertNull(queryEntity);

        TestTableEntity testTableEntity = TestDbEntityGen.genEntity1(TestConstants.FLAG1, TestConstants.FLAG1);

        int row = testTableMapper.insert(testTableEntity);
        assertEquals(1, row);

        queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        assertEquals(TestConstants.FLAG1, queryEntity.getFlag());

        row = testTableMapper.deleteByPrimaryKey(TestConstants.FLAG1);
        assertEquals(1, row);
    }
}
