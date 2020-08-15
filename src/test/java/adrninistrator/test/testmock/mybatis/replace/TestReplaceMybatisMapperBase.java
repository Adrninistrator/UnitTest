package adrninistrator.test.testmock.mybatis.replace;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import org.apache.ibatis.binding.MapperProxy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

@PrepareForTest({MapperProxy.class})
public abstract class TestReplaceMybatisMapperBase extends TestMockBase {

    @Autowired
    protected TestTableMapper testTableMapper;
}
