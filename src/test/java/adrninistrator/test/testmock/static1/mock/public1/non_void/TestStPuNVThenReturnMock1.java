package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

// 在不包含@Before、@Test注解的类中执行Mock、Stub等操作
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
