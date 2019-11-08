package test.testmock.static1.mock.other;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//对某个静态方法使用某条件设置Stub后，使用其他条件对该方法设置Stub，不会相互影响
public class TestStMockStubDiff extends TestStaticPublicNonVoidBase {

    @Test
    public void test() {

        TestTableEntity testTableEntity1 = new TestTableEntity();
        TestTableEntity testTableEntity2 = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1)).thenReturn
                (TestConstants.FLAG1);
        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2)).thenReturn
                (TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity1);
        Assert.assertEquals(TestConstants.FLAG1, str);

        str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, testTableEntity2);
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
