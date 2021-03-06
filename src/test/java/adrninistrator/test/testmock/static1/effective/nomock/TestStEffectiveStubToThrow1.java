package adrninistrator.test.testmock.static1.effective.nomock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// PowerMockito.stub().toThrow()执行多次的生效情况
public class TestStEffectiveStubToThrow1 extends TestStEffectiveBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // 最后一次PowerMockito.stub().toThrow()生效
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                TestStaticPublicNonVoid1.test1("", new TestTableEntity())
        );
        assertEquals(TestConstants.FLAG2, exception.getMessage());
    }
}
