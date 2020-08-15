package adrninistrator.test_jpa.test;

import adrninistrator.test_jpa.entity.TestTable3;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

// 测试主键类的equals与hashCode方法
public class TestEntityPrimaryKey {

    private static final Logger logger = LoggerFactory.getLogger(TestEntityPrimaryKey.class);

    private TestTable3.PrimaryKeys primaryKeys1;
    private TestTable3.PrimaryKeys primaryKeys2;
    private TestTable3.PrimaryKeys primaryKeys3;

    @Before
    public void init() {
        primaryKeys1 = new TestTable3.PrimaryKeys();
        primaryKeys1.setId("1");
        primaryKeys1.setFlag("1");

        primaryKeys2 = new TestTable3.PrimaryKeys();
        primaryKeys2.setId("1");
        primaryKeys2.setFlag("1");

        primaryKeys3 = new TestTable3.PrimaryKeys();
        primaryKeys3.setId("1");
        primaryKeys3.setFlag("2");
    }

    @Test
    public void test() {
        assertTrue(primaryKeys1.equals(primaryKeys2));
        assertFalse(primaryKeys1.equals(primaryKeys3));

        int hashCode1 = primaryKeys1.hashCode();
        int hashCode2 = primaryKeys2.hashCode();
        int hashCode3 = primaryKeys3.hashCode();

        logger.info("hashCode1: {}, hashCode2: {}, hashCode3: {}", hashCode1, hashCode2, hashCode3);

        assertEquals(hashCode1, hashCode2);
        assertNotEquals(hashCode1, hashCode3);
    }
}
