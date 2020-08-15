package adrninistrator.test.testmock.static1.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertThrows;

// 不执行PowerMockito.mockStatic()方法
// 执行Mockito.when()方法会出现异常
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStPuNVNoMock extends TestMockNoSpBase {

    @Test
    public void test() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                        .thenReturn(TestConstants.MOCKED)
        );
    }
}
