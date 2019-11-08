package test.testmock.static1.effective.mock;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.static1.effective.base.TestStEffectiveBase;

//Mockito.when()与PowerMockito.stub().toReturn()的生效情况
public class TestStEffectiveMockStRet1 extends TestStEffectiveBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG2);

        //PowerMockito.stub().toReturn()在Mockito.when()后执行，生效
        String str = TestStaticPublicNonVoid1.test4("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }

    @Test
    public void test2() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG1);

        //PowerMockito.stub.toReturn()后执行Mockito.when()会出现异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test3() {

        PowerMockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG2);

        //PowerMockito.stub().toReturn()在PowerMockito.when()后执行，生效
        String str = TestStaticPublicNonVoid1.test4("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }

    @Test
    public void test4() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG1);

        //PowerMockito.stub.toReturn()后执行PowerMockito.when()会出现异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        PowerMockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);
    }
}
