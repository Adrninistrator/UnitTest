package test.testmock.static1.mock.public1.void1;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.Location;
import org.mockito.stubbing.Answer;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.common.TestCommonUtil;

import java.util.Arrays;

public class AnswerStaticPublicVoid1 implements Answer<Void> {

    private static final Logger logger = LoggerFactory.getLogger(AnswerStaticPublicVoid1.class);

    //调用标志
    private boolean called = false;

    private String flag;

    public AnswerStaticPublicVoid1(String flag) {
        this.flag = flag;
    }

    @Override
    public Void answer(InvocationOnMock invocation) throws Throwable {

        //获取调用方法的代码信息
        Location location = Whitebox.getInternalState(invocation, Location.class);
        Object[] objects = invocation.getArguments();

        String locationStr = location.toString();

        logger.info("location: {}", locationStr);
        logger.info("getArguments: {}", Arrays.toString(objects));

        //检查调用方法是否符合预期
        Assert.assertTrue(locationStr.contains(flag));

        //获取第1个请求参数，类型为String
        StringBuffer arg1 = TestCommonUtil.getMockArg(invocation, 0, StringBuffer.class);

        //判断请求参数1是否符合预期
        if (TestConstants.FLAG3.equals(arg1.toString())) {

            //当请求参数1符合预期时，修改调用标志为真
            called = true;
        }

        //根据请求参数改变返回值

        //请求参数1等于TestConstants.FLAG1时，参数1设置为TestConstants.FLAG1+TestConstants.FLAG1
        if (TestConstants.FLAG1.equals(arg1.toString())) {
            arg1.setLength(0);
            arg1.append(TestConstants.FLAG1).append(TestConstants.FLAG1);

            return null;
        }

        //其他情况，参数1设置为固定值
        arg1.setLength(0);
        arg1.append(TestConstants.MOCKED);

        return null;
    }

    public boolean isCalled() {
        return called;
    }
}
