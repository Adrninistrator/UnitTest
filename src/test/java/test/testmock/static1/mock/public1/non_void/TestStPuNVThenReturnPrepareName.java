package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//使用@PrepareForTest注解的fullyQualifiedNames属性指定需要PowerMock准备的类
//修改返回值
public class TestStPuNVThenReturnPrepareName extends TestMockNoSpBase {

    @PrepareForTest(fullyQualifiedNames = "com.test.static1.TestStaticPublicNonVoid1")
    @Test
    public void test1() {

        doTest();
    }

    @PrepareForTest(fullyQualifiedNames = "com.test.static1.TestStaticPublicNonVoid1*")
    @Test
    public void test2() {

        doTest();
    }

    @PrepareForTest(fullyQualifiedNames = "com.test.static1.*")
    @Test
    public void test3() {

        doTest();
    }

    private void doTest() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
