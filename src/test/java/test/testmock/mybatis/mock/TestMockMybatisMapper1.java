package test.testmock.mybatis.mock;

import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.testmock.base.TestMockBase;

public class TestMockMybatisMapper1 extends TestMockBase {

    @Test
    public void test() {

        TestTableMapper testTableMapper = Mockito.mock(TestTableMapper.class);

        TestTableEntity entityReturn = new TestTableEntity();

        Mockito.when(testTableMapper.selectByPrimaryKey(Mockito.anyString())).thenReturn(entityReturn);

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey("");

        Assert.assertNotNull(testTableEntity);
    }
}
