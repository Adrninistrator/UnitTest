package adrninistrator.test.testmock.static1.mock.private1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
public class TestStPrNVVerify extends TestStaticPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        TestTableEntity testTableEntity1 = new TestTableEntity();

        TestTableEntity testTableEntity2 = new TestTableEntity();

        // 第1次verify
        testVerifyA(testTableEntity1);

        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 第2次verify
        testVerifyB(testTableEntity1);

        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 第3次verify
        testVerifyC(testTableEntity1, testTableEntity2);

        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG2, testTableEntity2);

        // 第4次verify
        testVerifyD(testTableEntity1, testTableEntity2);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

    // 第1次verify
    private void testVerifyA(TestTableEntity testTableEntity1) throws Exception {

        // 执行次数应为0
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(0));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数应为0
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(0));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito
                .anyString(), Mockito.any(TestTableEntity.class));
    }

    // 第2次verify
    private void testVerifyB(TestTableEntity testTableEntity1) throws Exception {

        // 执行次数应加1变为1
        Mockito.verify(TestStaticPrivateNonVoid1.class);
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito
                .anyString(), Mockito.any(TestTableEntity.class));

        // 执行次数应加1变为1
        Mockito.verify(TestStaticPrivateNonVoid1.class);
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数应加1变为1
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(1));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数应加1变为1
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.atLeastOnce());
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);
    }

    // 第3次verify
    private void testVerifyC(TestTableEntity testTableEntity1, TestTableEntity testTableEntity2) throws Exception {

        // 执行次数应加1变为2
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(2));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito
                .anyString(), Mockito.any(TestTableEntity.class));

        // 执行次数应加1变为2
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(2));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数应加1变为2
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.atLeast(2));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数应加1变为2
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.atMost(2));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,TestConstants
        // .FLAG2, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(0));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG2, testTableEntity2);

        // Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,TestConstants
        // .FLAG2, testTableEntity1)执行次数应为0
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.never());
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG2, testTableEntity2);
    }

    // 第4次verify
    private void testVerifyD(TestTableEntity testTableEntity1, TestTableEntity testTableEntity2) throws Exception {

        // 执行次数，应加1变为3
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(3));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito
                .anyString(), Mockito.any(TestTableEntity.class));

        // 执行次数，应为2不变
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(2));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG1, testTableEntity1);

        // 执行次数，应加1变为1
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(1));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, TestConstants
                .FLAG2, testTableEntity2);

        // Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,Mockito
        // .anyString(), Mockito.any(TestTableEntity.class))执行次数应为3
        Mockito.verify(TestStaticPrivateNonVoid1.class, Mockito.times(3));
        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito
                .anyString(), Mockito.any
                (TestTableEntity.class));
    }

}
