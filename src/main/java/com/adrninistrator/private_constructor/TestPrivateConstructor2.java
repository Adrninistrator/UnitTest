package com.adrninistrator.private_constructor;

import com.adrninistrator.common.constants.TestConstants;

public class TestPrivateConstructor2 {

    private String flag;

    public String getFlag() {
        return flag;
    }

    private TestPrivateConstructor2() {
        flag = TestConstants.FLAG1;
    }
}
