package adrninistrator.test.testmock.mybatis.mock;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

// 对Mapper对象的Mock对象进行Stub，修改select返回值
public class TestMockMybatisMapperReturn1 extends TestMockBase {

    @Test
    public void test() {
        TestTableMapper testTableMapper = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapper.selectByPrimaryKey(Mockito.anyString())).thenReturn(new TestTableEntity());

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey("");

        assertNotNull(testTableEntity);
    }
}
