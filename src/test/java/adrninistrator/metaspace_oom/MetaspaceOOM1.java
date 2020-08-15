package adrninistrator.metaspace_oom;

import javassist.CannotCompileException;
import javassist.ClassPool;
import org.junit.Test;

// 测试Metaspace内存溢出
public class MetaspaceOOM1 extends MetaspaceOOMBase {

    @Test
    public void test() throws CannotCompileException {

        ClassPool classPool = ClassPool.getDefault();
        int i = 0;
        while (true) {
            classPool.makeClass("test_MetaspaceOOM:" + i++).toClass();
        }
    }
}
