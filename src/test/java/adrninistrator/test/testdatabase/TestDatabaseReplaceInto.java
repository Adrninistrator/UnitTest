package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
测试 replace into
当不存在主键或唯一索引相同的数据时，执行插入操作
当存在主键或唯一索引相同的数据时，先删除旧数据再插入
返回受影响行数，即删除与插入的数据总和

以下插入时的日期字段值保持不变，防止使用MySQL时时间字段使用/不使用小数秒精度时字段值有区别

对于使用MySQL时的返回行数：
插入不存在主键或唯一索引相同的数据，返回对应记录行数
插入存在主键或唯一索引、其他字段均相同的数据，返回对应记录行数
插入存在主键或唯一索引相同，但其他字段不同的数据，返回对应记录行数*2
批量处理时，返回以上记录总和

对于使用H2时的返回行数区别：
插入存在主键或唯一索引、其他字段均相同的数据，返回对应记录行数*2
*/
public class TestDatabaseReplaceInto extends TestDbBase {

    private static final Logger logger = LoggerFactory.getLogger(TestDatabaseReplaceInto.class);

    @Autowired
    private TestTableMapper testTableMapper;

    private static Boolean h2OrMysql;

    @Before
    public void init() {
        if (h2OrMysql != null) {
            return;
        }

        logger.info("dataSource driverClassName: {}", druidDataSource.getDriverClassName());

        h2OrMysql = "org.h2.Driver".equals(druidDataSource.getDriverClassName());
    }

    // 单条记录
    @Test
    public void test1() {
        String id = TestIdGen.genId();
        Date date = new Date();
        TestTableEntity testTableEntity1 = TestDbEntityGen.genEntity1WithTime(id, TestConstants.FLAG1, date, date);

        // 不存在主键或唯一索引相同数据
        int row = testTableMapper.replaceInto(testTableEntity1);
        assertEquals(1, row);

        // 存在主键或唯一索引相同，其他字段均相同的数据
        row = testTableMapper.replaceInto(testTableEntity1);
        if (h2OrMysql) {
            assertEquals(2, row);
        } else {
            assertEquals(1, row);
        }

        TestTableEntity testTableEntity2 = TestDbEntityGen.genEntity1WithTime(id, TestConstants.FLAG2, date, date);
        // 存在主键或唯一索引相同，但其他字段不同的数据
        row = testTableMapper.replaceInto(testTableEntity2);
        assertEquals(2, row);
    }

    // 多条记录
    @Test
    public void test2() {
        Date date = new Date();
        List<TestTableEntity> list1 = TestDbEntityGen.genList1WithTime(5, TestConstants.FLAG1, date, date);

        // 不存在主键或唯一索引相同数据
        int row = testTableMapper.replaceIntoBatch(list1);
        assertEquals(5, row);

        // 存在主键或唯一索引相同，其他字段均相同的数据
        row = testTableMapper.replaceIntoBatch(list1);
        if (h2OrMysql) {
            assertEquals(5 * 2, row);
        } else {
            assertEquals(5, row);
        }

        List<TestTableEntity> list2 = TestDbEntityGen.copyList1WithTime(list1);
        // 存在主键或唯一索引相同，但其他字段不同的数据
        row = testTableMapper.replaceIntoBatch(list2);
        assertEquals(5 * 2, row);
    }

    // 多条记录，混和情况
    @Test
    public void test3() {
        Date date = new Date();
        List<TestTableEntity> list1 = TestDbEntityGen.genList1WithTime(3, TestConstants.FLAG1, date, date);

        // 不存在主键或唯一索引相同数据
        int row = testTableMapper.replaceIntoBatch(list1);
        assertEquals(3, row);

        List<TestTableEntity> list2 = TestDbEntityGen.genList1WithTime(4, TestConstants.FLAG1, date, date);
        List<TestTableEntity> list3 = TestDbEntityGen.copyList1WithTime(list1);
        List<TestTableEntity> listAll = new ArrayList<>(3 + 4 + 3);
        listAll.addAll(list1);
        listAll.addAll(list2);
        listAll.addAll(list3);

        /*
            部分数据不存在主键或唯一索引相同数据
            部分数据存在主键或唯一索引相同，其他字段均相同的数据
            部分数据存在主键或唯一索引相同，但其他字段不同的数据
        */
        row = testTableMapper.replaceIntoBatch(listAll);
        if (h2OrMysql) {
            assertEquals(3 * 2 + 4 + 3 * 2, row);
        } else {
            assertEquals(3 + 4 + 3 * 2, row);
        }
    }
}
