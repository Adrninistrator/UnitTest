package test.testdatabase;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestDatabaseMock extends TestMockBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test1() {

        TestTableEntity queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG2);
        Assert.assertNull(queryEntity);

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG2);
        testTableEntity.setFlag(TestConstants.FLAG2);

        int row = testTableMapper.insert(testTableEntity);
        Assert.assertEquals(1, row);

        queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, queryEntity.getFlag());

        testTableMapper.deleteByPrimaryKey(TestConstants.FLAG2);
    }

    @Test
    public void test2() {

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        TestTableEntity mockEntity = new TestTableEntity();
        mockEntity.setId(TestConstants.MOCKED);
        mockEntity.setFlag(TestConstants.MOCKED);

        Mockito.when(testTableMapperMock.selectByPrimaryKey(Mockito.anyString())).thenReturn(mockEntity);

        TestTableEntity queryEntity = testTableMapperMock.selectByPrimaryKey(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.MOCKED, queryEntity.getId());
        Assert.assertEquals(TestConstants.MOCKED, queryEntity.getFlag());
    }
}
