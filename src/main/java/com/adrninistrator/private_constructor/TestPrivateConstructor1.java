package com.adrninistrator.private_constructor;

public class TestPrivateConstructor1 {

    private TestPrivateConstructor1() {
        throw new IllegalStateException("illegal");
    }
}
