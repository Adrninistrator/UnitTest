package test.testdatabase;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDatabase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {

        TestTableEntity queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        Assert.assertNull(queryEntity);

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        int row = testTableMapper.insert(testTableEntity);
        Assert.assertEquals(1, row);

        queryEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.FLAG1, queryEntity.getFlag());

        row = testTableMapper.deleteByPrimaryKey(TestConstants.FLAG1);
        Assert.assertEquals(1, row);
    }
}
