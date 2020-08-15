package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
测试 insert on duplicate key update
当不存在主键或唯一索引相同的数据时，执行插入操作
当存在主键或唯一索引相同的数据时，执行更新操作

以下仅更新flag字段，不更新日期字段，防止使用MySQL时时间字段使用/不使用小数秒精度时更新返回行数有区别

返回行数（MySQL的jdbc连接参数使用useAffectedRows=true时的结果，若为false时返回的行数会不同）：
当执行插入时，返回插入的行数
当执行更新时，返回更新的行数*2
当未执行插入或更新时，返回0
批量处理时，返回以上记录总和
*/
public class TestDatabaseInsertUpdate extends TestDbBase {

    @Autowired
    private TestTableMapper testTableMapper;

    // 单条记录
    @Test
    public void test1() {
        String id = TestIdGen.genId();
        TestTableEntity testTableEntity1 = TestDbEntityGen.genEntity1(id, TestConstants.FLAG1);

        // 执行插入
        int row = testTableMapper.insertOrUpdate(testTableEntity1);
        assertEquals(1, row);

        TestTableEntity entityQuery = testTableMapper.selectByPrimaryKey(id);
        assertNotNull(entityQuery);
        assertEquals(TestConstants.FLAG1, entityQuery.getFlag());

        TestTableEntity testTableEntity2 = TestDbEntityGen.genEntity1(id, TestConstants.FLAG2);
        // 执行更新
        row = testTableMapper.insertOrUpdate(testTableEntity2);
        assertEquals(2, row);

        entityQuery = testTableMapper.selectByPrimaryKey(id);
        assertNotNull(entityQuery);
        assertEquals(TestConstants.FLAG2, entityQuery.getFlag());

        // 不执行插入或更新
        row = testTableMapper.insertOrUpdate(testTableEntity2);
        assertEquals(0, row);
    }

    // 多条记录
    @Test
    public void test2() {
        List<TestTableEntity> list = TestDbEntityGen.genList1(5, TestConstants.FLAG1);
        List<TestTableEntity> list2 = TestDbEntityGen.copyList1(list);

        // 执行插入
        int row = testTableMapper.insertOrUpdateBatch(list);
        assertEquals(5, row);

        // 执行更新
        row = testTableMapper.insertOrUpdateBatch(list2);
        assertEquals(10, row);

        // 不执行插入或更新
        row = testTableMapper.insertOrUpdateBatch(list2);
        assertEquals(0, row);
    }

    // 多条记录，部分插入
    @Test
    public void test3() {
        List<TestTableEntity> list1 = TestDbEntityGen.genList1(3, TestConstants.FLAG1);

        // 执行插入
        int row = testTableMapper.insertOrUpdateBatch(list1);
        assertEquals(3, row);

        List<TestTableEntity> list2 = TestDbEntityGen.genList1(2, TestConstants.FLAG1);
        List<TestTableEntity> listAll = new ArrayList<>(3 + 2);
        listAll.addAll(list1);
        listAll.addAll(list2);

        // 对不存在的数据进行插入
        row = testTableMapper.insertOrUpdateBatch(listAll);
        assertEquals(2, row);
    }

    // 多条记录，部分插入及更新
    @Test
    public void test4() {
        List<TestTableEntity> list1a = TestDbEntityGen.genList1(3, TestConstants.FLAG1);

        // 执行插入
        int row = testTableMapper.insertOrUpdateBatch(list1a);
        assertEquals(3, row);

        List<TestTableEntity> list1b = TestDbEntityGen.copyList1(list1a);
        List<TestTableEntity> list2 = TestDbEntityGen.genList1(2, TestConstants.FLAG1);
        List<TestTableEntity> listAll = new ArrayList<>(3 + 2);
        listAll.addAll(list1b);
        listAll.addAll(list2);

        // 对不存在的数据进行插入，存在的数据更新
        row = testTableMapper.insertOrUpdateBatch(listAll);
        assertEquals(2 + 3 * 2, row);
    }
}
