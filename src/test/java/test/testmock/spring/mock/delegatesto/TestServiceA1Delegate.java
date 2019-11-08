package test.testmock.spring.mock.delegatesto;

import com.test.common.TestConstants;
import com.test.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

//被委托的代表
//使用Spring的@Component组件
@Service
public class TestServiceA1Delegate {

    public String test1(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.MOCKED;
    }

    public void test2(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        stringBuffer.append(TestConstants.MOCKED);
    }

    public String test3(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.MOCKED;
    }

    public void test4(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        stringBuffer.append(TestConstants.MOCKED);
    }
}
