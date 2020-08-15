package adrninistrator.test.common;

import java.lang.annotation.*;

// 自定义注解，指定执行初始化操作的TestInitInterface实现类
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestInitAnnotation {

    Class<? extends TestInitInterface>[] value();
}
