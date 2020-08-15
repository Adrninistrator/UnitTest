package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
public class TestStPuNVVerify extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        TestTableEntity testTableEntity1 = new TestTableEntity();

        TestTableEntity testTableEntity2 = new TestTableEntity();

        // 第1次verify
        testVerifyA(testTableEntity1);

        // 执行TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 第2次verify
        testVerifyB(testTableEntity1);

        // 执行TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 第3次verify
        testVerifyC(testTableEntity1, testTableEntity2);

        // 执行TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2)
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2);

        // 第4次verify
        testVerifyD(testTableEntity1, testTableEntity2);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    // 第1次verify
    private void testVerifyA(TestTableEntity testTableEntity1) {
        // 初始，TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(0));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 初始，TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(0));
        TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument)), Mockito
                .argThat(argument -> testTableEntity1.equals(argument)));

        // 初始，TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.never());
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 初始，TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.atMostOnce());
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
    }

    // 第2次verify
    private void testVerifyB(TestTableEntity testTableEntity1) {
        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为1
        Mockito.verify(TestStaticPublicNonVoid1.class);
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为1
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class));

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为1
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.atLeastOnce());
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
    }

    // 第3次verify
    private void testVerifyC(TestTableEntity testTableEntity1, TestTableEntity testTableEntity2) {
        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为2
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(2));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为2
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.atLeast(2));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应加1变为2
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.atMost(2));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(0));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.never());
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2);
    }

    // 第4次verify
    private void testVerifyD(TestTableEntity testTableEntity1, TestTableEntity testTableEntity2) {
        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数，应为2不变
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(2));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2)执行次数，应加1变为1
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2);

        // TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))执行次数应为3
        Mockito.verify(TestStaticPublicNonVoid1.class, Mockito.times(3));
        TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class));
    }

    @Test
    public void test2() {
        TestTableEntity testTableEntity1 = new TestTableEntity();

        // 初始，TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为0
        PowerMockito.verifyStatic(TestStaticPublicNonVoid1.class, Mockito.times(0));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // 执行TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);

        // TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)执行次数应为1
        PowerMockito.verifyStatic(TestStaticPublicNonVoid1.class, Mockito.times(1));
        TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
    }
}
