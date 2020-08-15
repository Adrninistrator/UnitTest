package adrninistrator.test.testmock.mybatis.spy;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThrows;

// 对Mapper对象执行Mockito.spy操作，会出现异常
public class TestSpyMybatisMapperError extends TestMockBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {
        // 应出现指定异常
        assertThrows(Exception.class, () ->
                Mockito.spy(testTableMapper)
        );
    }
}
