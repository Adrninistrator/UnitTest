package adrninistrator.metaspace_oom;

import org.junit.Test;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

// 测试Metaspace内存溢出
public class MetaspaceOOM2 extends MetaspaceOOMBase {

    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
            ClassNotFoundException {

        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        List<Object> list = new ArrayList<>(100000);
        while (true) {
            Constructor<?> constructor = reflectionFactory.newConstructorForSerialization(MetaspaceOOM2.class);
            list.add(constructor);
        }
    }
}
