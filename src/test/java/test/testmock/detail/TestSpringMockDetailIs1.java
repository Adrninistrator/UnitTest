package test.testmock.detail;

import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSpringMockDetailIs1 extends TestSpringMockDetailBase {

    @Autowired
    private TestServiceA1 testServiceA1;

    @Spy
    private TestServiceA1 testServiceA1Spy = new TestServiceA1Impl();

    @Test
    public void test1() {

        Assert.assertFalse(Mockito.mockingDetails(testServiceA1).isMock());
        Assert.assertFalse(Mockito.mockingDetails(testServiceA1).isSpy());

        Assert.assertTrue(Mockito.mockingDetails(testServiceA1Mock).isMock());
        Assert.assertFalse(Mockito.mockingDetails(testServiceA1Mock).isSpy());

        Assert.assertTrue(Mockito.mockingDetails(testServiceA1Spy).isMock());
        Assert.assertFalse(Mockito.mockingDetails(testServiceA1Spy).isSpy());
    }

    @Test
    public void test2() {

        TestServiceA1 testServiceA1Mock2 = Mockito.mock(TestServiceA1.class);

        TestServiceA1 testServiceA1Spy2 = Mockito.spy(testServiceA1);

        Assert.assertTrue(Mockito.mockingDetails(testServiceA1Mock2).isMock());
        Assert.assertFalse(Mockito.mockingDetails(testServiceA1Mock2).isSpy());

        Assert.assertTrue(Mockito.mockingDetails(testServiceA1Spy2).isMock());
        Assert.assertTrue(Mockito.mockingDetails(testServiceA1Spy2).isSpy());
    }
}
