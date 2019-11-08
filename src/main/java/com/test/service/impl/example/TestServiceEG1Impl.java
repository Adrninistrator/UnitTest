package com.test.service.impl.example;

import com.test.service.example.TestServiceEG1;
import org.springframework.stereotype.Service;

@Service
public class TestServiceEG1Impl implements TestServiceEG1 {

    @Override
    public boolean checkA(String str) {
        return false;
    }
}
