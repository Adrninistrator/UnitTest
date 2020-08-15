package adrninistrator.test.common;

import java.util.concurrent.atomic.AtomicInteger;

public class TestIdGen {

    private static AtomicInteger ai = new AtomicInteger(0);

    public static String genId() {
        // test + 当前时间戳 + 自增数字
        long time = System.currentTimeMillis();
        int num = ai.incrementAndGet();
        return String.format("test%x%x", time, num);
    }

    private TestIdGen() {
        throw new IllegalStateException("illegal");
    }
}
