package adrninistrator.test.testdatabase;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestDatabaseMock extends TestMockBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test1() {
        TestTableEntity queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG2);
        assertNull(queryEntity);

        TestTableEntity testTableEntity = TestDbEntityGen.genEntity1(TestConstants.FLAG2, TestConstants.FLAG2);

        int row = testTableMapper.insert(testTableEntity);
        assertEquals(1, row);

        queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, queryEntity.getFlag());

        testTableMapper.deleteByPrimaryKey(TestConstants.FLAG2);
    }

    @Test
    public void test2() {
        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        TestTableEntity mockEntity = TestDbEntityGen.genEntity1(TestConstants.MOCKED, TestConstants.MOCKED);

        Mockito.when(testTableMapperMock.selectByPrimaryKey(Mockito.anyString())).thenReturn(mockEntity);

        TestTableEntity queryEntity = testTableMapperMock.selectByPrimaryKey(TestConstants.FLAG1);
        assertEquals(TestConstants.MOCKED, queryEntity.getId());
        assertEquals(TestConstants.MOCKED, queryEntity.getFlag());
    }
}
