package adrninistrator.test.testmock.detail;

import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// 识别指定对象是否为Mock/Spy对象
public class TestSpringMockDetailIs1 extends TestSpringMockDetailBase {

    @Autowired
    private TestServiceA1 testServiceA1;

    @Spy
    private TestServiceA1 testServiceA1Spy = new TestServiceA1Impl();

    @Test
    public void test1() {
        assertFalse(Mockito.mockingDetails(new TestServiceA1Impl()).isMock());
        assertFalse(Mockito.mockingDetails(new TestServiceA1Impl()).isSpy());

        assertTrue(Mockito.mockingDetails(Mockito.mock(TestServiceA1.class)).isMock());
        assertTrue(Mockito.mockingDetails(Mockito.spy(TestServiceA1.class)).isSpy());
    }

    @Test
    public void test2() {
        assertFalse(Mockito.mockingDetails(testServiceA1).isMock());
        assertFalse(Mockito.mockingDetails(testServiceA1).isSpy());

        assertTrue(Mockito.mockingDetails(testServiceA1Mock).isMock());
        assertFalse(Mockito.mockingDetails(testServiceA1Mock).isSpy());

        assertTrue(Mockito.mockingDetails(testServiceA1Spy).isMock());
        assertFalse(Mockito.mockingDetails(testServiceA1Spy).isSpy());
    }

    @Test
    public void test3() {
        TestServiceA1 testServiceA1Mock2 = Mockito.mock(TestServiceA1.class);

        TestServiceA1 testServiceA1Spy2 = Mockito.spy(testServiceA1);

        assertTrue(Mockito.mockingDetails(testServiceA1Mock2).isMock());
        assertFalse(Mockito.mockingDetails(testServiceA1Mock2).isSpy());

        assertTrue(Mockito.mockingDetails(testServiceA1Spy2).isMock());
        assertTrue(Mockito.mockingDetails(testServiceA1Spy2).isSpy());
    }
}
