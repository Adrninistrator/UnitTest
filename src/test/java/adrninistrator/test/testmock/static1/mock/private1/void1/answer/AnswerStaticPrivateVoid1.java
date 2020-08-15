package adrninistrator.test.testmock.static1.mock.private1.void1.answer;

import com.adrninistrator.common.constants.TestConstants;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.Location;
import org.mockito.stubbing.Answer;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AnswerStaticPrivateVoid1 implements Answer<Void> {

    private static final Logger logger = LoggerFactory.getLogger(AnswerStaticPrivateVoid1.class);

    // 调用标志
    private boolean called = false;

    @Override
    public Void answer(InvocationOnMock invocation) throws Throwable {

        // 获取调用方法的代码信息
        Location location = Whitebox.getInternalState(invocation, Location.class);
        Object[] objects = invocation.getArguments();

        String locationStr = location.toString();

        logger.info("location: {}", locationStr);
        logger.info("getArguments: {}", Arrays.toString(objects));

        // 获取第1个请求参数，类型为String
        StringBuilder arg1 = invocation.getArgument(0);

        // 判断请求参数1是否符合预期
        if (TestConstants.FLAG3.equals(arg1.toString())) {
            // 当请求参数1符合预期时，修改调用标志为真
            called = true;
        }

        // 根据请求参数改变调用参数

        // 请求参数1等于TestConstants.FLAG1时，参数1设置为TestConstants.FLAG1+TestConstants.FLAG1
        if (TestConstants.FLAG1.equals(arg1.toString())) {
            arg1.setLength(0);
            arg1.append(TestConstants.FLAG1).append(TestConstants.FLAG1);

            return null;
        }

        // 其他情况，参数1设置为固定值
        arg1.setLength(0);
        arg1.append(TestConstants.MOCKED);

        return null;
    }

    public boolean isCalled() {
        return called;
    }
}
