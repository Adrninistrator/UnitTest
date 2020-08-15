package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/*
测试 insert ignore
插入时若出现错误会被忽略，例如主键或唯一索引出现重复数据
返回行数为实际执行了插入的数据行数
*/
public class TestDatabaseInsertIgnore extends TestDbBase {

    @Autowired
    private TestTableMapper testTableMapper;

    // 插入单条记录
    @Test
    public void test1() {
        TestTableEntity testTableEntity = TestDbEntityGen.genEntity1(TestIdGen.genId(), TestConstants.FLAG1);

        // 插入，不存在相同数据
        int row = testTableMapper.insertIgnore(testTableEntity);
        assertEquals(1, row);

        // 插入，存在相同数据
        row = testTableMapper.insertIgnore(testTableEntity);
        assertEquals(0, row);

        // 插入，重复数据
        assertThrows(DuplicateKeyException.class, () ->
                testTableMapper.insert(testTableEntity)
        );
    }

    // 插入多条记录
    @Test
    public void test2() {
        List<TestTableEntity> list = TestDbEntityGen.genList1(5, TestConstants.FLAG1);

        // 插入，不存在相同数据
        int row = testTableMapper.insertIgnoreBatch(list);
        assertEquals(5, row);

        // 插入，全部存在相同数据
        row = testTableMapper.insertIgnoreBatch(list);
        assertEquals(0, row);
    }

    // 插入多条记录，部分已存在
    @Test
    public void test3() {
        List<TestTableEntity> list1 = TestDbEntityGen.genList1(3, TestConstants.FLAG1);

        // 插入，不存在相同数据
        int row = testTableMapper.insertIgnoreBatch(list1);
        assertEquals(3, row);

        List<TestTableEntity> list2 = TestDbEntityGen.genList1(2, TestConstants.FLAG1);
        List<TestTableEntity> listAll = new ArrayList<>(3 + 2);
        listAll.addAll(list1);
        listAll.addAll(list2);

        // 插入，部分存在相同数据
        row = testTableMapper.insertIgnoreBatch(listAll);
        assertEquals(2, row);
    }
}
