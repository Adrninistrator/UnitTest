package adrninistrator.test.testmock.mybatis.mock;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

// 对Mapper对象的Mock对象进行Stub，抛出异常
public class TestMockMybatisMapperThrows extends TestMockBase {

    @Test
    public void test() {
        TestTableMapper testTableMapper = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapper.selectByPrimaryKey(Mockito.anyString())).thenThrow(new RuntimeException(TestConstants.MOCKED));

        assertThrows(RuntimeException.class, () ->
                testTableMapper.selectByPrimaryKey("")
        );
    }
}
