package adrninistrator.test.testdatabase;

import adrninistrator.test.base.TestDbBase;
import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.dao.TestTable2Mapper;
import com.adrninistrator.dao.entity.TestTable2WithBLOBs;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertThrows;

// 测试插入重复数据
public class TestDatabaseDuplicateKey extends TestDbBase {

    @Autowired
    private TestTable2Mapper testTable2Mapper;

    @Test
    public void test1() {
        String id = TestIdGen.genId();

        TestTable2WithBLOBs testTable2WithBLOBs = genTestTable2WithBLOBs();
        testTable2WithBLOBs.setId(id);
        testTable2WithBLOBs.setChar1("-");
        testTable2WithBLOBs.setChar2(id);

        testTable2Mapper.insert(testTable2WithBLOBs);

        testTable2WithBLOBs.setChar2(TestIdGen.genId());

        // 主键冲突，应出现异常
        assertThrows(DuplicateKeyException.class, () ->
                testTable2Mapper.insert(testTable2WithBLOBs)
        );
    }

    @Test
    public void test2() {
        String id = TestIdGen.genId();

        TestTable2WithBLOBs testTable2WithBLOBs = genTestTable2WithBLOBs();
        testTable2WithBLOBs.setId(id);
        testTable2WithBLOBs.setChar1("-");
        testTable2WithBLOBs.setChar2(id);

        testTable2Mapper.insert(testTable2WithBLOBs);

        testTable2WithBLOBs.setId(TestIdGen.genId());

        // 唯一索引冲突，应出现异常
        assertThrows(DuplicateKeyException.class, () ->
                testTable2Mapper.insert(testTable2WithBLOBs)
        );
    }

    private TestTable2WithBLOBs genTestTable2WithBLOBs() {
        TestTable2WithBLOBs testTable2WithBLOBs = new TestTable2WithBLOBs();
        testTable2WithBLOBs.setBlob1("blob1".getBytes());
        testTable2WithBLOBs.setBlob2("blob2".getBytes());
        testTable2WithBLOBs.setText1("text1");
        testTable2WithBLOBs.setText2("text2");
        testTable2WithBLOBs.setInt1(1);
        testTable2WithBLOBs.setInt2(2);
        testTable2WithBLOBs.setDecimal1(0L);
        testTable2WithBLOBs.setDecimal2(BigDecimal.TEN);
        testTable2WithBLOBs.setDatetime1(new Date());
        testTable2WithBLOBs.setDatetime2(new Date());
        testTable2WithBLOBs.setTimestamp1(new Date());
        testTable2WithBLOBs.setTimestamp2(new Date());

        return testTable2WithBLOBs;
    }
}
