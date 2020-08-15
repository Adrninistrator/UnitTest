package adrninistrator.test.testmock.mockpolicy.conflict.stub;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub2;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*
    @PrepareForTest注解在类级别，指定PowerMockPolicy实现类中需要处理的类
    全部方法@MockPolicy注解不生效
 */
@MockPolicy({TestPolicyStub2.class})
@PrepareForTest({TestStaticPublicNonVoid1.class, TestPublicNonVoidService1Impl.class})
public class TestMockPolicyConflictStC2 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
