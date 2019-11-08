package test.testmock.mybatis.spy;

import com.test.dao.TestTableMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

public abstract class TestSpyMybatisMapperError extends TestMockBase {

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.spy(testTableMapper);
    }
}
