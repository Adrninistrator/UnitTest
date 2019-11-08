package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;

//不执行PowerMockito.mockStatic()方法
//执行Mockito.when()方法会出现异常
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStPuNVNoMock extends TestMockNoSpBase {

    @Test
    public void test() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);
    }
}
