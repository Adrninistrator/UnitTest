package test.testmock.static1.effective.nomock;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.static1.effective.base.TestStEffectiveBase;

import java.io.FileNotFoundException;

//PowerMockito.stub().toThrow()执行多次的生效情况
public class TestStEffectiveStubToThrow1 extends TestStEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        //最后一次PowerMockito.stub().toThrow()生效
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.FLAG2);

        TestStaticPublicNonVoid1.test1("", new TestTableEntity());
    }
}
