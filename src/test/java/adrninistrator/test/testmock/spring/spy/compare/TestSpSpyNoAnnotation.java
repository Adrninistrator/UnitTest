package adrninistrator.test.testmock.spring.spy.compare;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.TestService2;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

// 创建Spy对象，使用Mockito.spy()方法
public class TestSpSpyNoAnnotation extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Autowired
    private TestService2 testService2;

    @Autowired
    private TestServiceA1 testServiceA1;

    @Autowired
    private TestServiceB1 testServiceB1;

    // 对@Autowired注入的对象使用Mockito.spy产生的对象，可执行真实方法，与直接调用原对象效果相同（未Stub的方法）
    @Test
    public void test1() {
        TestPublicNonVoidService1 testPublicNonVoidService1Spy = Mockito.spy(testPublicNonVoidService1);

        String str = testPublicNonVoidService1Spy.test3("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        // Mockito.spy返回对象的被注入对象非空
        TestTableMapper testTableMapper = Whitebox.getInternalState(testPublicNonVoidService1Spy, TestTableMapper
                .class);
        assertNotNull(testTableMapper);
    }

    // 对Whitebox.getInternalState()通过反射获取的对象，支持使用Mockito.spy
    @Test
    public void test2() {
        TestPublicNonVoidService1 testPublicNonVoidService1In = Whitebox.getInternalState(testService2,
                TestPublicNonVoidService1.class);

        TestPublicNonVoidService1 testPublicNonVoidService1Spy = Mockito.spy(testPublicNonVoidService1In);

        String str = testPublicNonVoidService1Spy.test3("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        // Mockito.spy返回对象的被注入对象非空
        TestTableMapper testTableMapper = Whitebox.getInternalState(testPublicNonVoidService1Spy, TestTableMapper.class);
        assertNotNull(testTableMapper);
    }

    @Test
    public void test3() {
        // 各个类中注入的同一个类的对象是同一个
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        assertSame(testServiceA1, testServiceA1InB1);
    }
}
