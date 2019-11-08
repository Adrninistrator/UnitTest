package test.testmock.mybatis.mock;

import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//对Mapper接口执行Mockito.mock操作时，指定默认Answer为CallsRealMethods，执行其方法时不会执行真实方法
public class TestMockMybatisMapper2 extends TestMockBase {

    private String time;

    @Autowired
    private TestTableMapper testTableMapper;

    @Before
    public void init() {

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class, Mockito.withSettings()
                .defaultAnswer(new CallsRealMethods()));

        time = String.valueOf(System.currentTimeMillis());

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(time);
        testTableEntity.setFlag(time);

        int row = testTableMapperMock.insert(testTableEntity);

        Assert.assertEquals(0, row);
    }

    @Test
    public void test() {

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        Assert.assertNull(testTableEntity);
    }
}
