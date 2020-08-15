package adrninistrator.test.testmock.mybatis.mock;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestService3;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 对Mapper对象的Mock对象进行Stub，修改insert/select返回值
public class TestMockMybatisMapperReturn2 extends TestMockBase {

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

        assertEquals(TestConstants.DEFAULT_INT, row);

        TestTableEntity testTableEntity = testService3.select(time);

        assertNotNull(testTableEntity);
        assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
