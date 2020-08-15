package adrninistrator.test.testmock.spring.async;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestAsyncService1;
import com.adrninistrator.service.impl.TestAsyncService1Impl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.assertEquals;

public class TestAsyncRawGet extends TestMockBase {

    @Autowired
    private TestAsyncService1 testAsyncService1;

    @Test
    public void test() {
        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAsyncService1 testAsyncService1Raw = AopTestUtils.getTargetObject(testAsyncService1);

        assertEquals(TestAsyncService1Impl.class, testAsyncService1Raw.getClass());
    }
}
