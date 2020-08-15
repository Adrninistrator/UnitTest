package adrninistrator.test.testmock.mybatis.delegatesto;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestService3;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

// 将Mapper对象，替换为调用转发给委托的Mock对象，可执行真实方法或返回指定值
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

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class, AdditionalAnswers.delegatesTo(testMybatisDelegate));

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
