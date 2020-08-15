package adrninistrator.test.testmock.mybatis.mock;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 执行Mockito.mock()方法创建Mapper对象的Mock对象时，指定默认Answer为执行真实方法，执行Mock对象的方法时，不会执行真实方法
public class TestMockMybatisMapperNotCallRealMethod extends TestMockBase {

    private String time;

    @Autowired
    private TestTableMapper testTableMapper;

    @Before
    public void init() {
        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class, new CallsRealMethods());

        time = String.valueOf(System.currentTimeMillis());

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(time);
        testTableEntity.setFlag(time);

        int row = testTableMapperMock.insert(testTableEntity);

        assertEquals(0, row);
    }

    @Test
    public void test() {
        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        assertNull(testTableEntity);
    }
}
