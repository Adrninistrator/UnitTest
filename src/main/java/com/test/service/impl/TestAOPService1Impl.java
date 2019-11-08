package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestService2;
import com.test.util.TestCallTimesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAOPService1Impl implements TestAOPService1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAOPService1Impl.class);

    public static final String NAME_TESTAROUND = "testAround";

    @Autowired
    private TestService2 testService2;

    @Override
    public String testAround(String str) {

        logger.info("testAround");

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    @Override
    public String test2(String str) {

        return testService2.test1(str);
    }
}
