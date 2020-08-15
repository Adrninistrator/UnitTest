package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertSame;

// 获取私有成员变量
public class TestGetPrivateField extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() throws IllegalAccessException {

        TestTableMapper testTableMapper1 = (TestTableMapper) PowerMockito.field(TestPublicNonVoidService1Impl.class,
                "testTableMapper").get(testPublicNonVoidService1);

        TestTableMapper testTableMapper2 = Whitebox.getInternalState(testPublicNonVoidService1, TestTableMapper.class);

        TestTableMapper testTableMapper3 = Whitebox.getInternalState(testPublicNonVoidService1, "testTableMapper");

        assertSame(testTableMapper1, testTableMapper2);

        assertSame(testTableMapper2, testTableMapper3);
    }
}
