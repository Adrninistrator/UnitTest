package test.testmock.other;

import com.test.dao.TestTableMapper;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestGetPrivateField extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() throws IllegalAccessException {

        TestTableMapper testTableMapper1 = (TestTableMapper) PowerMockito.field(TestPublicNonVoidService1Impl.class,
                "testTableMapper").get(testPublicNonVoidService1);

        TestTableMapper testTableMapper2 = Whitebox.getInternalState(testPublicNonVoidService1, TestTableMapper.class);

        TestTableMapper testTableMapper3 = Whitebox.getInternalState(testPublicNonVoidService1, "testTableMapper");

        Assert.assertSame(testTableMapper1, testTableMapper2);

        Assert.assertSame(testTableMapper2, testTableMapper3);
    }
}
