package adrninistrator.test.testmock.example.test;

import adrninistrator.test.common.TestInitAnnotation;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.example.init.TestInitEGANotPass;
import com.adrninistrator.service.example.TestServiceEG4;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

// 通过@TestInitAnnotation注解指定TestInitEGANotPass.class，使testServiceEG4.test()方法执行testServiceEG1.checkA()方法时不通过检查
@TestInitAnnotation({TestInitEGANotPass.class})
public class TestEG_ANOTPASS extends TestMockBase {

    @Autowired
    private TestServiceEG4 testServiceEG4;

    @Test
    public void test() {
        String str = testServiceEG4.test("");

        assertNull(str);
    }
}
