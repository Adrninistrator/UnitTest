package adrninistrator.test.testmock.static1.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// 使用@PrepareForTest注解的fullyQualifiedNames属性指定需要PowerMock准备的类
// 修改返回值
public class TestStPuNVThenReturnPrepareName extends TestMockNoSpBase {

    @PrepareForTest(fullyQualifiedNames = "com.adrninistrator.static1.TestStaticPublicNonVoid1")
    @Test
    public void test1() {
        doTest();
    }

    @PrepareForTest(fullyQualifiedNames = "com.adrninistrator.static1.TestStaticPublicNonVoid1*")
    @Test
    public void test2() {
        doTest();
    }

    @PrepareForTest(fullyQualifiedNames = "com.adrninistrator.static1.*")
    @Test
    public void test3() {
        doTest();
    }

    private void doTest() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.MOCKED, str);
    }
}
