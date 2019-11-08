package test.testmock.mybatis.mock;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestService3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestMockMybatisMapper4 extends TestMockBase {

    private String time;

    @Autowired
    private TestService3 testService3;

    @Before
    public void init() {

        time = String.valueOf(System.currentTimeMillis());

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapperMock.insert(
                Mockito.argThat(argument -> time.equals(argument.getId()) && time.equals(argument.getFlag()))))
                .thenAnswer(invocation -> TestConstants.DEFAULT_INT);

        Mockito.when(testTableMapperMock.selectByPrimaryKey(time)).thenAnswer(invocation -> {

            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        });

        Whitebox.setInternalState(testService3, testTableMapperMock);
    }

    @Test
    public void test() {

        TestTableEntity entity4Insert = new TestTableEntity();
        entity4Insert.setId(time);
        entity4Insert.setFlag(time);

        int row = testService3.insert(entity4Insert);

        Assert.assertEquals(TestConstants.DEFAULT_INT, row);

        TestTableEntity testTableEntity = testService3.select(time);

        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
