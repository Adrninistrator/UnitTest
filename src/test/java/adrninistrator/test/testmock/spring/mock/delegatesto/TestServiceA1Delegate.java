package adrninistrator.test.testmock.spring.mock.delegatesto;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

/*
    被委托的代表
    使用Spring的@Component组件
    在applicationContext.xml的context:component-scan配置中添加了当前类所在的包
 */
@Service
public class TestServiceA1Delegate {

    public String test1(String str) {
        TestCallTimesUtil.addCallTimes();

        return TestConstants.MOCKED;
    }

    public void test2(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        stringBuilder.append(TestConstants.MOCKED);
    }

    public String test3(String str) {
        TestCallTimesUtil.addCallTimes();

        return TestConstants.MOCKED;
    }

    public void test4(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        stringBuilder.append(TestConstants.MOCKED);
    }
}
