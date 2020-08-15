package adrninistrator.metaspace_oom;

import org.junit.Before;

// 测试Metaspace内存溢出，基类
public abstract class MetaspaceOOMBase {

    @Before
    public void init() {
        System.out.println("-Xms256m -Xmx256m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=64m -XX:+PrintGC -XX:+PrintGCDetails " +
                "-XX:+PrintGCTimeStamps");
        System.out.println("-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=MetaSpaceOOM.hprof");
    }
}
