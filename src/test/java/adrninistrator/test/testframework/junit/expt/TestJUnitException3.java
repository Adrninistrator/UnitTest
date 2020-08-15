package adrninistrator.test.testframework.junit.expt;

import adrninistrator.test.common.TestMatcherExpClassEquals;
import adrninistrator.test.common.TestMatcherExpClassIsInstance;
import adrninistrator.test.common.TestMatcherExpMsgContains;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// 使用Matcher接口的自定义类，可以实现比较复杂的异常检查操作
public class TestJUnitException3 {

    @SuppressWarnings("deprecation")
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @SuppressWarnings("unchecked")
    @Test
    public void test1() {
        // 应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(new TestMatcherExpMsgContains(TestConstants.MOCKED));

        testException();
    }

    @Test
    public void test2() {
        // 出现的异常应继承自指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        testException();
    }

    private void testException() {
        throw new RuntimeException(TestConstants.MOCKED);
    }
}
