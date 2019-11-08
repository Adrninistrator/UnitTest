package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//根据请求参数决定修改返回值、抛出异常或执行真实方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVModifyRsp1 extends TestMockNoSpBase {

    @Before
    public void init() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> {

                    String arg0 = (String) args[0];

                    if (TestConstants.FLAG1.equals(arg0)) {

                        return TestConstants.FLAG1;
                    } else if (TestConstants.FLAG2.equals(arg0)) {

                        throw new RuntimeException(TestConstants.FLAG2);
                    } else if (TestConstants.FLAG3.equals(arg0)) {

                        return method.invoke(proxy, args);
                    }

                    return TestConstants.MOCKED;
                });
    }

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, null);

        Assert.assertEquals(TestConstants.FLAG1, str);
    }

    @Test
    public void test2() {

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.FLAG2);

        TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
    }

    @Test
    public void test3() {

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG3, null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
