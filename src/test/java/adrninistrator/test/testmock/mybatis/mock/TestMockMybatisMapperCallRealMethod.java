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

import static org.junit.Assert.*;

// 对Mapper对象的Mock对象进行Stub，当请求参数满足条件时执行真实方法
public class TestMockMybatisMapperCallRealMethod extends TestMockBase {

    private String time;

    @Autowired
    private TestService3 testService3;

    @Autowired
    private TestTableMapper testTableMapper;

    @Before
    public void init() {
        time = String.valueOf(System.currentTimeMillis());

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapperMock.insert(
                Mockito.argThat(argument -> time.equals(argument.getId()) && time.equals(argument.getFlag()))))
                .thenAnswer(invocation -> {

                    TestTableEntity arg1 = invocation.getArgument(0);

                    return testTableMapper.insert(arg1);
                });

        Mockito.when(testTableMapperMock.selectByPrimaryKey(time)).thenAnswer(invocation -> {

            String arg1 = invocation.getArgument(0);

            return testTableMapper.selectByPrimaryKey(arg1);
        });

        Whitebox.setInternalState(testService3, testTableMapperMock);
    }

    @Test
    public void test1() {
        TestTableEntity entity4Insert = new TestTableEntity();
        entity4Insert.setId(time);
        entity4Insert.setFlag(time);

        int row = testService3.insert(entity4Insert);

        assertEquals(1, row);

        TestTableEntity testTableEntity = testService3.select(time);

        assertNotNull(testTableEntity);
        assertEquals(time, testTableEntity.getId());
        assertEquals(time, testTableEntity.getFlag());
    }

    @Test
    public void test2() {
        TestTableEntity entity4Insert = new TestTableEntity();
        entity4Insert.setId(TestConstants.FLAG1);
        entity4Insert.setFlag(TestConstants.FLAG1);

        int row = testService3.insert(entity4Insert);

        assertEquals(0, row);

        TestTableEntity testTableEntity = testService3.select(time);

        assertNull(testTableEntity);
    }
}
