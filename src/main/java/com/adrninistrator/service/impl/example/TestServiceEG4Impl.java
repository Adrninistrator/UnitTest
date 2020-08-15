package com.adrninistrator.service.impl.example;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.example.TestServiceEG1;
import com.adrninistrator.service.example.TestServiceEG2;
import com.adrninistrator.service.example.TestServiceEG3;
import com.adrninistrator.service.example.TestServiceEG4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceEG4Impl implements TestServiceEG4 {

    @Autowired
    private TestServiceEG1 testServiceEG1;

    @Autowired
    private TestServiceEG2 testServiceEG2;

    @Autowired
    private TestServiceEG3 testServiceEG3;

    @Override
    public String test(String str) {
        // 步骤A
        if (!testServiceEG1.checkA(str)) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder(TestConstants.FLAG1);

        // 步骤B
        String resultB = testServiceEG2.checkB(str);
        if (TestConstants.FLAG1.equals(resultB)) {
            stringBuilder.append(TestConstants.FLAG1);

            // 步骤C
            doTest(str, stringBuilder);

            return stringBuilder.toString();
        }

        if (TestConstants.FLAG2.equals(resultB)) {
            stringBuilder.append(TestConstants.FLAG2);

            return stringBuilder.toString();
        }

        stringBuilder.append(TestConstants.MINUS);

        return stringBuilder.toString();
    }

    private void doTest(String str, StringBuilder stringBuilder) {
        String resultC = testServiceEG3.checkC(str);

        if (TestConstants.FLAG1.equals(resultC)) {
            stringBuilder.append(TestConstants.FLAG1);
            return;
        }

        if (TestConstants.FLAG2.equals(resultC)) {
            stringBuilder.append(TestConstants.FLAG2);
            return;
        }

        stringBuilder.append(TestConstants.MINUS);

    }
}
