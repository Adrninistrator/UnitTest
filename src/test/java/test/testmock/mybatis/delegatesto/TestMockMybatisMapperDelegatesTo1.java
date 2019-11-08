package test.testmock.mybatis.delegatesto;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestService3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestMockMybatisMapperDelegatesTo1 extends TestMockBase {

    private String time;

    @Autowired
    private TestService3 testService3;

    @Autowired
    private TestMybatisDelegate testMybatisDelegate;

    @Before
    public void init() {

        time = String.valueOf(System.currentTimeMillis());

        testMybatisDelegate.setTime(time);

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class, AdditionalAnswers.delegatesTo
                (testMybatisDelegate));

        Whitebox.setInternalState(testService3, testTableMapperMock);
    }

    @Test
    public void test1() {

        TestTableEntity entity4Insert = new TestTableEntity();
        entity4Insert.setId(time);
        entity4Insert.setFlag(time);

        int row = testService3.insert(entity4Insert);

        Assert.assertEquals(1, row);

        TestTableEntity testTableEntity = testService3.select(time);

        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(time, testTableEntity.getId());
        Assert.assertEquals(time, testTableEntity.getFlag());
    }

    @Test
    public void test2() {

        TestTableEntity entity4Insert = new TestTableEntity();
        entity4Insert.setId(TestConstants.FLAG1);
        entity4Insert.setFlag(TestConstants.FLAG1);

        int row = testService3.insert(entity4Insert);

        Assert.assertEquals(0, row);
        TestTableEntity testTableEntity = testService3.select(time);

        Assert.assertNull(testTableEntity);
    }
}
