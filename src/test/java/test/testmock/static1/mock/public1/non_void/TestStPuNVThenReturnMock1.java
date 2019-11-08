package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

//在不包含@Before、@Test注解的类中执行Mock、Stub等操作
public class TestStPuNVThenReturnMock1 {

    public static void mock() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity
                .class))).thenReturn(TestConstants.MOCKED);
    }

    private TestStPuNVThenReturnMock1() {
        throw new IllegalStateException("illegal");
    }
}
