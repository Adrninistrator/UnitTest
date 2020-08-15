package adrninistrator.test.testmock.static1.mock.private1.non_void.answer;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.Location;
import org.mockito.stubbing.Answer;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AnswerStaticPrivateNonVoid1 implements Answer<String> {

    private static final Logger logger = LoggerFactory.getLogger(AnswerStaticPrivateNonVoid1.class);

    // 调用标志
    private boolean called = false;

    // 预期标志
    private String callFlag;

    public AnswerStaticPrivateNonVoid1(String callFlag) {
        this.callFlag = callFlag;
    }

    @Override
    public String answer(InvocationOnMock invocation) throws Throwable {

        // 获取调用方法的代码信息
        Location location = Whitebox.getInternalState(invocation, Location.class);
        Object[] objects = invocation.getArguments();

        String locationStr = location.toString();

        logger.info("location: {}", locationStr);
        logger.info("getArguments: {}", Arrays.toString(objects));

        // 获取第1个请求参数，类型为String
        String arg1 = invocation.getArgument(0);

        // 判断请求参数1是否符合预期
        if (callFlag.equals(arg1)) {
            // 当请求参数1符合预期时，修改调用标志为真
            called = true;
        }

        // 获取第2个请求参数，类型为TestTableEntity
        TestTableEntity testTableEntity = invocation.getArgument(1);

        // 根据请求参数改变返回值

        // 请求参数testTableEntity.getFlag()等于TestConstants.FLAG1时，返回该值
        if (TestConstants.FLAG1.equals(testTableEntity.getFlag())) {
            return TestConstants.FLAG1;
        }

        // 其他情况，返回固定值
        return TestConstants.MOCKED;
    }

    public boolean isCalled() {
        return called;
    }
}
