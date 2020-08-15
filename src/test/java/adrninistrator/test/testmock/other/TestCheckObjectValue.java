package adrninistrator.test.testmock.other;

import adrninistrator.test.common.TestCommonUtil;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTable2;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertThrows;

// 测试检查对象字段值是否等于预期值的简化方法：TestCommonUtil.checkObjectValue
public class TestCheckObjectValue {

    private static final Logger logger = LoggerFactory.getLogger(TestCheckObjectValue.class);

    // 预期字段值与实际字段值相同，类型：字符串
    @Test
    public void test1() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        TestCommonUtil.checkObjectValue(testTableEntity, new Object[]{"id", TestConstants.FLAG1, "flag", TestConstants.FLAG1});
    }

    // 预期字段值与实际字段值相同，类型：字符串、int、long、BigDecimal、Date
    @Test
    public void test2() {

        Date date = new Date();

        TestTable2 testTable2 = new TestTable2();
        testTable2.setId(TestConstants.FLAG1);
        testTable2.setChar1(TestConstants.FLAG1);
        testTable2.setChar2(TestConstants.FLAG1);
        testTable2.setText2(TestConstants.FLAG1);
        testTable2.setInt1(1);
        testTable2.setInt2(2);
        testTable2.setDecimal1(100L);
        testTable2.setDecimal2(BigDecimal.TEN);
        testTable2.setDatetime1(date);
        testTable2.setDatetime2(date);
        testTable2.setTimestamp1(date);
        testTable2.setTimestamp2(date);

        TestCommonUtil.checkObjectValue(testTable2, new Object[]{"id", TestConstants.FLAG1, "char1", TestConstants.FLAG1,
                "char2", TestConstants.FLAG1, "text2", TestConstants.FLAG1, "int1", 1, "int2", 2, "decimal1", 100L, "decimal2", BigDecimal.TEN,
                "datetime1", date, "datetime2", date, "timestamp1", date, "timestamp2", date});
    }

    // 预期字段值与实际字段值不相同，类型：字符串
    @Test
    public void test3() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        AssertionError e = assertThrows(AssertionError.class, () ->
                TestCommonUtil.checkObjectValue(testTableEntity, new Object[]{"id", TestConstants.FLAG1, "flag", TestConstants.FLAG2})
        );
        logger.error("error ", e);
    }

    // 预期字段值与实际字段值不相同，类型：Date
    @Test
    public void test4() {
        Date date = new Date();

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);
        testTableEntity.setCreateTime(date);
        testTableEntity.setUpdateTime(new Date(date.getTime() + 100L));

        AssertionError e = assertThrows(AssertionError.class, () ->
                TestCommonUtil.checkObjectValue(testTableEntity, new Object[]{"id", TestConstants.FLAG1, "flag", TestConstants.FLAG1,
                        "createTime", date, "updateTime", date})
        );
        logger.error("error ", e);
    }

    // 预期字段不存在
    @Test
    public void test5() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);

        FieldNotFoundException e = assertThrows(FieldNotFoundException.class, () ->
                TestCommonUtil.checkObjectValue(testTableEntity, new Object[]{"id1", TestConstants.FLAG1})
        );
        logger.error("error ", e);
    }

    // 预期字段值为null
    @Test
    public void test6() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);

        AssertionError e = assertThrows(AssertionError.class, () ->
                TestCommonUtil.checkObjectValue(testTableEntity, new Object[]{"flag", TestConstants.FLAG1})
        );
        logger.error("error ", e);
    }
}
