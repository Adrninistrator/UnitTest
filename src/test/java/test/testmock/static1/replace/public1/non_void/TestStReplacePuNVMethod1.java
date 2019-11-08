package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;

//将真实方法替换为目标方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVMethod1 extends TestMockNoSpBase {

    private static boolean called = false;

    @Test
    public void test1() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePuNVMethod1.class, "replace_test1"));

        Assert.assertFalse(called);

        String str = TestStaticPublicNonVoid1.test1("", null);

        Assert.assertEquals(TestConstants.MOCKED, str);

        Assert.assertTrue(called);

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    @Test
    public void test2() {

        //PowerMockito.replace().with()方法，要求被替换的方法，及替换后的方法均为静态方法，因此会出现异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePuNVMethod1.class, "replace_test2"));
    }

    public static String replace_test1(String str, TestTableEntity testTableEntity) {

        called = true;

        return TestConstants.MOCKED;
    }

    public String replace_test2(String str, TestTableEntity testTableEntity) {

        return null;
    }
}
