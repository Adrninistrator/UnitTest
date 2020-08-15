package adrninistrator.test.testmock.static1.mock.public1.non_void.test_prepare;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.powermock.core.classloader.annotations.PrepareForTest;

// 测试@PrepareForTest注解是否可以在测试类及超类中指定，父类
@PrepareForTest({TestStaticPublicNonVoid2.class})
public abstract class TestPrepareForTestParent extends TestMockBase {
}
