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

//Mockito.when()与PowerMockito.suppress()的生效情况
public class TestStEffectiveMockSu1 extends TestStEffectiveBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test1() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));

        //PowerMockito.suppress后执行Mockito.when会出现异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4));

        //PowerMockito.suppress生效
        String str = TestStaticPublicNonVoid1.test4("");
        Assert.assertNull(str);
    }
}
