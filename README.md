# 1. 前言

以下内容提供了Java单元测试实践总结，包含9万多字文档，与700多个测试示例。

# 2. 相关文档地址

- 01.单元测试概述与示例

[https://blog.csdn.net/a82514921/article/details/108028826](https://blog.csdn.net/a82514921/article/details/108028826)

- 02.使用JUnit进行单元测试

[https://blog.csdn.net/a82514921/article/details/107969370](https://blog.csdn.net/a82514921/article/details/107969370)

- 03.使用spring-test进行单元测试

[https://blog.csdn.net/a82514921/article/details/107969384](https://blog.csdn.net/a82514921/article/details/107969384)

- 04.使用IDEA、Eclipse执行单元测试

[https://blog.csdn.net/a82514921/article/details/108029070](https://blog.csdn.net/a82514921/article/details/108029070)

- 05.Mockito、PowerMock基本功能使用

[https://blog.csdn.net/a82514921/article/details/107969395](https://blog.csdn.net/a82514921/article/details/107969395)

- 06.Mock后Stub静态方法

[https://blog.csdn.net/a82514921/article/details/107969410](https://blog.csdn.net/a82514921/article/details/107969410)

- 07.Answer与未Stub的静态方法

[https://blog.csdn.net/a82514921/article/details/107969432](https://blog.csdn.net/a82514921/article/details/107969432)

- 08.Stub、Replace、Suppress静态方法

[https://blog.csdn.net/a82514921/article/details/108029093](https://blog.csdn.net/a82514921/article/details/108029093)

- 09.Mockito的Stub参数条件

[https://blog.csdn.net/a82514921/article/details/107969976](https://blog.csdn.net/a82514921/article/details/107969976)

- 10.Mock非静态方法

[https://blog.csdn.net/a82514921/article/details/107969997](https://blog.csdn.net/a82514921/article/details/107969997)

- 11.Mock后Stub Spring的@Component组件

[https://blog.csdn.net/a82514921/article/details/107970029](https://blog.csdn.net/a82514921/article/details/107970029)

- 12.Answer与未Stub的Spring组件方法

[https://blog.csdn.net/a82514921/article/details/107970064](https://blog.csdn.net/a82514921/article/details/107970064)

- 13.Spy后Stub Spring的@Component组件

[https://blog.csdn.net/a82514921/article/details/107970241](https://blog.csdn.net/a82514921/article/details/107970241)

- 14.Mock、Spy后Stub Spring成员变量中的方法

[https://blog.csdn.net/a82514921/article/details/108029138](https://blog.csdn.net/a82514921/article/details/108029138)

- 15.Stub、Replace、Suppress Spring的方法

[https://blog.csdn.net/a82514921/article/details/107970253](https://blog.csdn.net/a82514921/article/details/107970253)

- 16.Spring AOP与Mock

[https://blog.csdn.net/a82514921/article/details/107970278](https://blog.csdn.net/a82514921/article/details/107970278)

- 17.Mybatis与Mock

[https://blog.csdn.net/a82514921/article/details/107970290](https://blog.csdn.net/a82514921/article/details/107970290)

- 18.使用注解进行Stub、Replace、Suppress

[https://blog.csdn.net/a82514921/article/details/107970298](https://blog.csdn.net/a82514921/article/details/107970298)

- 19.Mockito与PowerMock的其他功能

[https://blog.csdn.net/a82514921/article/details/107970307](https://blog.csdn.net/a82514921/article/details/107970307)

- 20.Mock相关总结

[https://blog.csdn.net/a82514921/article/details/108029299](https://blog.csdn.net/a82514921/article/details/108029299)

- 21.使用Gradle执行单元测试

[https://blog.csdn.net/a82514921/article/details/108029309](https://blog.csdn.net/a82514921/article/details/108029309)

- 22.Gradle资源文件与配置参数动态替换

[https://blog.csdn.net/a82514921/article/details/108029162](https://blog.csdn.net/a82514921/article/details/108029162)

- 23.Gradle单元测试日志、报告与JaCoCo代码覆盖率

[https://blog.csdn.net/a82514921/article/details/108029178](https://blog.csdn.net/a82514921/article/details/108029178)

- 24.Gradle执行test任务卡死问题解决

[https://blog.csdn.net/a82514921/article/details/108029198](https://blog.csdn.net/a82514921/article/details/108029198)

- 25.在本地使用H2数据库进行单元测试

[https://blog.csdn.net/a82514921/article/details/108029222](https://blog.csdn.net/a82514921/article/details/108029222)

- 26.使用JPA自动创建数据库表

[https://blog.csdn.net/a82514921/article/details/108041847](https://blog.csdn.net/a82514921/article/details/108041847)

- 27.JPA Entity生成工具Java组件增强版

[https://blog.csdn.net/a82514921/article/details/108041881](https://blog.csdn.net/a82514921/article/details/108041881)

- 28.spring-test数据库操作自动回滚处理

[https://blog.csdn.net/a82514921/article/details/108041899](https://blog.csdn.net/a82514921/article/details/108041899)

- Spring MVC 单元测试
未完待续

# 3. 目录

- 01.单元测试概述与示例

```
1. 前言
2. 示例工程
3. 依赖环境版本
4. 单元测试可以做什么
    4.1. 提高代码质量
    4.2. 提升开发效率
    4.3. 降低异常情况的测试复杂度
    4.4. 起到部分回归测试的作用
    4.5. 以直观的方式展示重要功能
    4.6. 处理开发相关的安全问题
5. 哪些代码需要进行单元测试
6. 单元测试需要关注的场景
    6.1. 方法入口参数检查
    6.2. 业务功能的主要流程
7. 单元测试代码编写建议
    7.1. AIR原则
        7.1.1. A-自动化
            7.1.1.1. 执行过程自动化
            7.1.1.2. 执行结果检查自动化
        7.1.2. I-独立性
        7.1.3. R-可重复
    7.2. BCDE原则
    7.3. 其他建议
8. 单元测试与Mock
    8.1. 使用Mock的目的
    8.2. 需要Mock的代码
    8.3. 不需要Mock的代码
    8.4. 数据依赖与Mock的使用
9. 单元测试执行步骤
    9.1. 执行测试代码
    9.2. 数据初始化
    9.3. 代码Mock
    9.4. 摆脱数据库环境依赖
    9.5. 检查执行结果
    9.6. 生成测试结果报告
    9.7. 生成代码覆盖率报告
    9.8. 清理测试数据
10. 其他内容
    10.1. 单元测试的阶段
    10.2. 单元测试能否替代其他类型的测试
    10.3. 单元测试维护
    10.4. 检查单元测试效果
    10.5. 单元测试时间占比
    10.6. 单元测试与集成测试
11. 参考资料
```

- 02.使用JUnit进行单元测试

```
1. 使用JUnit进行单元测试
    1.1. JUnit4
        1.1.1. 添加引用
        1.1.2. @RunWith配置
        1.1.3. 注解对应方法执行顺序
        1.1.4. 注解对应方法执行次数
        1.1.5. 注解对应方法在子类及超类中的执行顺序
        1.1.6. 子类覆盖超类的注解对应方法
        1.1.7. @Test注解的位置
        1.1.8. @Test方法执行顺序
        1.1.9. @Test方法与测试类实例
        1.1.10. 断言
            1.1.10.1. 抛出异常
            1.1.10.2. 比较值是否相同/是否为同一个对象
            1.1.10.3. 使用匹配器Matcher
                1.1.10.3.1. 使用简化的Matcher实现类
        1.1.11. 异常测试
            1.1.11.1. 使用@Test注解的expected属性
            1.1.11.2. 使用ExpectedException类
            1.1.11.3. 使用Matcher接口实现类检查异常信息
            1.1.11.4. 使用Assert.assertThrows()方法检查异常信息
        1.1.12. 使用Suite
    1.2. JUnit5
        1.2.1. 添加引用
        1.2.2. 对于IDE的支持
        1.2.3. 注解
        1.2.4. 从JUnit4迁移到JUnit5
        1.2.5. Mock框架支持
            1.2.5.1. Mockito支持
            1.2.5.2. PowerMock不支持JUnit5
2. 单元测试代码需要注意的其他问题
    2.1. 等待异步线程
    2.2. 基类设置为抽象类
    2.3. 使用MockDriver类作为数据源驱动
```

- 03.使用spring-test进行单元测试

```
1. 使用spring-test进行单元测试
    1.1. 基本配置
        1.1.1. SpringJUnit4ClassRunner
        1.1.2. 上下文配置注解@ContextConfiguration
    1.2. 测试工具类
        1.2.1. ReflectionTestUtils
        1.2.2. AopTestUtils
    1.3. Spring Context加载次数
        1.3.1. Context缓存
        1.3.2. 禁用Context缓存
        1.3.3. Spring Context加载次数验证
        1.3.4. 使用PowerMock时Context缓存失效
    1.4. 测试执行监听器TestExecutionListener
        1.4.1. Spring默认提供的TestExecutionListener实现
        1.4.2. TestExecutionListener提供的方法
        1.4.3. 注册自定义TestExecutionListener
    1.5. 加快Spring应用单元测试启动速度
    1.6. Spring JUnit4支持类
    1.7. spring-test示例工程
```

- 04.使用IDEA、Eclipse执行单元测试

```
1. 使用IDEA、Eclipse执行单元测试
    1.1. IntelliJ IDEA
        1.1.1. 支持的功能
        1.1.2. 对JUnint的支持
            1.1.2.1. JUnit引用
            1.1.2.2. 执行单个类
            1.1.2.3. 执行单个方法
            1.1.2.4. 执行多个类
        1.1.3. main模块与test模块资源文件生效情况
        1.1.4. 修改测试代码执行方式
    1.2. Eclipse
        1.2.1. 支持的功能
        1.2.2. 对JUnint的支持
            1.2.2.1. JUnit引用
            1.2.2.2. 执行单个类
            1.2.2.3. 执行单个方法
            1.2.2.4. 执行多个类
        1.2.3. main模块与test模块资源文件生效情况
```

- 05.Mockito、PowerMock基本功能使用

```
1. Mockito与PowerMock的功能
    1.1. Mockito
    1.2. PowerMock
2. 添加引用
    2.1. 引用Mockito
    2.2. 引用PowerMock
3. PowerMock对Mockito的支持版本
4. 基本配置
    4.1. @RunWith(PowerMockRunner.class)
    4.2. @PrepareForTest注解
    4.3. @PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
    4.4. @PowerMockIgnore
5. Mock框架依赖组件、版本差别等
    5.1. 依赖组件的影响
        5.1.1. javassist
    5.2. Mockito 2与Mockito 1版本的区别
    5.3. PowerMock不同版本的区别
6. Mock与Stub
```

- 06.Mock后Stub静态方法

```
1. Mock后Stub静态方法
    1.1. Mock包含静态方法的类
        1.1.1. 使用@PrepareForTest注解
        1.1.2. PowerMockito.mockStatic()方法
    1.2. Stub静态公有非void方法
        1.2.1. 修改返回值
            1.2.1.1. 使用@PrepareForTest注解fullyQualifiedNames参数
        1.2.2. 抛出异常
        1.2.3. 使用Answer实现回调
            1.2.3.1. 在Answer中执行真实方法
            1.2.3.2. 在Answer中修改方法返回值
            1.2.3.3. 在Answer中抛出异常
            1.2.3.4. 使用匿名类实现Answer
            1.2.3.5. 使用lambda表达式实现Answer接口
            1.2.3.6. 获取请求参数
            1.2.3.7. 修改调用参数并执行真实方法
            1.2.3.8. 获取调用方法信息
            1.2.3.9. 判断指定方法是否执行
            1.2.3.10. 延长方法执行耗时
        1.2.4. 使用verify判断方法的执行次数
            1.2.4.1. 使用Captor获取调用参数
        1.2.5. 执行真实方法
    1.3. Stub静态公有void方法
        1.3.1. 抛出异常
        1.3.2. 使用Answer实现回调
        1.3.3. 使用verify判断方法的执行次数
            1.3.3.1. 使用Captor获取调用参数
        1.3.4. 执行真实方法
        1.3.5. doNothing
    1.4. Stub静态私有非void方法
    1.5. Stub静态私有void方法
    1.6. 其他内容
        1.6.1. PowerMockito.mockStatic()执行多次
        1.6.2. 多次执行Stub
        1.6.3. 对相同方法的不同条件的Stub
```

- 07.Answer与未Stub的静态方法

```
1. Answer与未Stub的静态方法
2. 未Stub的方法的返回值
3. 被Stub方法条件不满足的返回值
4. 未Stub的方法的返回值处理分析
5. 对类进行Mock时设置默认Answer
    5.1. 相关的类
        5.1.1. Mockito类中的Answer实现类
        5.1.2. Answers枚举中的Answer实现类
        5.1.3. answers包中的Answer实现类
    5.2. 执行真实方法
    5.3. 抛出异常
    5.4. 什么也不做
6. Mockito.when()操作导致真实方法被执行或抛出异常
    6.1. Mockito.when()操作执行真实方法或抛出异常的原因分析
    6.2. 避免Stub操作执行真实方法或抛出异常
```

- 08.Stub、Replace、Suppress静态方法

```
1. Stub、Replace、Suppress静态方法
    1.1. 对静态方法进行Stub
        1.1.1. 获得Method对象
        1.1.2. 使用@PrepareForTest注解
        1.1.3. toReturn()与toThrow()方法
        1.1.4. 使用Stubber.stubMethod()方法进行Stub
        1.1.5. PowerMockito.stub()方法与静态方法
    1.2. 对静态方法进行Replace
        1.2.1. 使用@PrepareForTest注解
        1.2.2. 使用InvocationHandler进行Replace处理
            1.2.2.1. 使用lambda表达式进行Replace
            1.2.2.2. 通过method.invoke()执行真实方法
            1.2.2.3. 获取调用参数等信息
            1.2.2.4. 修改调用参数并执行真实方法
            1.2.2.5. 获取调用堆栈
            1.2.2.6. 判断指定方法是否执行
                1.2.2.6.1. 延长方法执行耗时
        1.2.3. 替换静态方法
        1.2.4. 使用MethodProxy.proxy()方法进行Replace
        1.2.5. PowerMockito.replace()方法与静态方法
    1.3. 对静态方法所在的类进行Suppress
        1.3.1. 对字段进行Suppress
            1.3.1.1. 使用@PrepareForTest注解
            1.3.1.2. 被Suppress字段的值
            1.3.1.3. 获取字段实际值
            1.3.1.4. 使用SuppressCode.suppressField()对字段进行Suppress
        1.3.2. 对方法进行Suppress
            1.3.2.1. 使用@PrepareForTest注解
            1.3.2.2. 被Suppress方法的返回值
            1.3.2.3. 使用SuppressCode.suppressMethod()对方法进行Suppress
            1.3.2.4. 对全部方法（不含构造函数）进行Suppress
            1.3.2.5. 对全部方法（包含构造函数）进行Suppress
        1.3.3. 被Suppress字段的值分析
        1.3.4. 被Suppress方法返回值分析
        1.3.5. 对静态代码块进行Suppress
        1.3.6. PowerMockito.suppress()方法与静态方法
    1.4. 对同一个方法执行Mock后Stub、Stub、Replace、Suppress等操作的生效情况
```

- 09.Mockito的Stub参数条件

```
1. Mockito的Stub参数条件
    1.1. 等于指定值
    1.2. 等于指定类型
    1.3. 等于任意类型
    1.4. 等于指定类型或为null
    1.5. 等于指定值
    1.6. 与指定对象为同一个对象
    1.7. 与指定对象的成员变量值相同
    1.8. 为空
    1.9. 非空
    1.10. String类型参数支持的方法
        1.10.1. 以指定字符串开头
        1.10.2. 以指定字符串结尾
        1.10.3. 包含指定字符串
        1.10.4. 满足指定的正则表达式
    1.11. 使用自定义的参数匹配器
        1.11.1. 使用匿名类
        1.11.2. 使用lambda表达式设置Stub条件
        1.11.3. 对方法设置多个自定义参数匹配器
        1.11.4. 对基本类型使用匹配器
    1.12. 参数为数组
    1.13. 参数为范型
    1.14. 变长参数
    1.15. ArgumentMatchers类的方法不能与固定值一起使用
    1.16. Mockito.any(Class<T> type)对于超类及子类的生效情况
    1.17. 使用Class对象作为参数
```

- 10.Mock非静态方法

```
1. Mock非静态方法
    1.1. Mock后Stub非静态方法
        1.1.1. 生成非静态方法对应的类的Mock对象
        1.1.2. Stub单例模式类的非静态方法
        1.1.3. Stub无参数构造函数
            1.1.3.1. 在测试代码调用构造函数
            1.1.3.2. 在被测试代码调用构造函数
            1.1.3.3. 在被测试代码的内部类调用构造函数
        1.1.4. Stub有参数构造函数
            1.1.4.1. 有参数构造函数的Stub条件
            1.1.4.2. 使用@PrepareForTest注解
            1.1.4.3. 不满足有参数构造函数Stub条件
        1.1.5. 不支持对原始对象进行Stub
    1.2. Spy后Stub非静态方法
        1.2.1. 生成非静态方法对应的类的Spy对象
        1.2.2. Mockito.spy()方法比较
    1.3. 对非静态方法进行Suppress
        1.3.1. Suppress构造函数
            1.3.1.1. Suppress唯一的构造函数
            1.3.1.2. Suppress全部的构造函数
            1.3.1.3. Suppress默认的构造函数
            1.3.1.4. 使用SuppressCode.suppressConstructor()进行Suppress
```

- 11.Mock后Stub Spring的@Component组件

```
1. Spring Context加载次数
2. Mock后Stub Spring的@Component组件
    2.1. 创建Mock对象
    2.2. Mock对象类名标志
    2.3. 同一个类的多个Mock对象
    2.4. Stub @Component组件Mock对象公有非void方法
        2.4.1. 修改返回值
        2.4.2. 抛出异常
        2.4.3. 使用Answer实现回调
        2.4.4. 使用verify判断方法的执行次数
            2.4.4.1. 使用Captor获取调用参数
        2.4.5. 执行真实方法
        2.4.6. Stub同一个方法多次，每次执行不同的Stub操作
    2.5. Stub @Component组件Mock对象公有void方法
        2.5.1. 抛出异常
        2.5.2. 使用Answer实现回调
        2.5.3. 使用verify判断方法的执行次数
            2.5.3.1. 使用Captor获取调用参数
        2.5.4. 执行真实方法
        2.5.5. 什么也不做
    2.6. Stub @Component组件Mock对象私有非void方法
        2.6.1. Mockito.mock()返回的Mock对象
        2.6.2. 使用@PrepareForTest注解
        2.6.3. 修改返回值
        2.6.4. 抛出异常
        2.6.5. 使用Answer实现回调
        2.6.6. 使用verify判断方法的执行次数
            2.6.6.1. 使用Captor获取调用参数
        2.6.7. 执行真实方法
    2.7. Stub @Component组件Mock对象私有void方法
```

- 12.Answer与未Stub的Spring组件方法

```
1. Answer与未Stub的Spring组件方法
    1.1. 未Stub的方法的返回值
    1.2. 未Stub的方法的返回值处理分析
    1.3. 被Stub方法条件不满足的返回值
    1.4. 设置未Stub的方法的默认Answer
        1.4.1. 执行真实方法
        1.4.2. 抛出异常
        1.4.3. 什么也不做
        1.4.4. 使用@Mock注解的answer参数
        1.4.5. MockSettings的stubOnly属性
        1.4.6. 委托方法调用
    1.5. Mockito.when()操作导致真实方法被执行或抛出异常
        1.5.1. Mockito.when()操作执行真实方法或抛出异常的原因分析
        1.5.2. 避免Stub操作执行真实方法或抛出异常
```

- 13.Spy后Stub Spring的@Component组件

```
1. Spy后Stub Spring的@Component组件
    1.1. 创建Spy对象
    1.2. Spy对象的Stub方法选择
    1.3. Stub @Component组件Spy对象公有非void方法
    1.4. Stub @Component组件Spy对象公有void方法
    1.5. Stub @Component组件Spy对象私有非void方法
    1.6. Stub @Component组件Spy对象私有void方法
    1.7. 未Stub的方法的返回值
    1.8. 被Stub方法条件不满足的返回值
    1.9. Spy对象类名标志
    1.10. 同一个类的多个Spy对象
```

- 14.Mock、Spy后Stub Spring成员变量中的方法

```
1. Mock/Spy后Stub Spring成员变量中的方法
    1.1. 使用Mock对象对成员变量进行替换
        1.1.1. 替换成员变量为Mock对象
        1.1.2. 替换成员变量的成员变量为Mock对象
        1.1.3. Spring Bean单例与变量替换
        1.1.4. 将多个类引用的实例替换为独立的Mock对象
        1.1.5. 替换成员变量时防止覆盖Stub操作
        1.1.6. 变量替换与Stub的顺序
    1.2. 使用Spy对象对成员变量进行替换
```

- 15.Stub、Replace、Suppress Spring的方法

```
1. Stub、Replace、Suppress Spring的方法
    1.1. 对Spring的@Component组件方法进行Stub
    1.2. 对Spring的@Component组件方法进行Replace
    1.3. 对Spring的@Component组件进行Suppress
        1.3.1. 对字段进行Suppress
        1.3.2. 对方法进行Suppress
    1.4. 对同一个方法执行Mock/Spy后Stub、Stub、Replace、Suppress的生效情况
```

- 16.Spring AOP与Mock

```
1. Spring AOP与Mock
    1.1. 查看AOP代理对象信息
    1.2. 获取代理对象对应的原始对象
    1.3. 将被引用的AOP代理对象替换为原始对象
    1.4. 将被引用的AOP代理对象替换为Mock对象
    1.5. 将被引用的AOP代理对象替换为Spy对象
    1.6. 对Aspect进行Stub/Replace
    1.7. 对原始对象进行Stub/Replace
    1.8. 替换AOP原始对象中的成员变量
2. 对使用了事务的类进行Mock
3. 对使用了@Async注解的类进行Mock
```

- 17.Mybatis与Mock

```
1. Mybatis与Mock
    1.1. 测试示例说明
    1.2. Mapper对象类名
    1.3. 对Mapper对象进行Mock
        1.3.1. 修改Mapper对象的Mock对象的返回值/抛出异常
        1.3.2. 使Mapper对象的Mock对象执行真实方法
    1.4. 对Mapper对象进行Spy
        1.4.1. Mapper对象不支持Spy操作
        1.4.2. 对MapperProxy进行Spy
            1.4.2.1. 对MapperProxy进行Spy的过程
            1.4.2.2. MapperProxy.invoke()方法调用参数
            1.4.2.3. 支持的Stub操作
    1.5. 对MapperProxy类的invoke()方法进行Replace
    1.6. 对Mapper对象委托方法调用
    1.7. 在test模块使用mybatis-generator
```

- 18.使用注解进行Stub、Replace、Suppress

```
1. 使用@MockPolicy注解进行Stub、Replace、Suppress
    1.1. PowerMockPolicy使用方法
    1.2. 使用@MockPolicy注解进行Stub操作
    1.3. 使用@MockPolicy注解进行Replace操作
    1.4. 使用@MockPolicy注解进行Suppress操作
    1.5. 使用多个PowerMockPolicy实现类时的生效情况
    1.6. @MockPolicy注解与Stub、Replace、Suppress同时使用的生效情况
    1.7. @PrepareForTest注解导致@MockPolicy注解失效
        1.7.1. 使用自定义注解替代@MockPolicy注解的部分功能
```

- 19.Mockito与PowerMock的其他功能

```
1. Mockito与PowerMock的其他功能
    1.1. 获取Mock对象详细信息
        1.1.1. 判断指定对象是否为Mock/Spy对象
            1.1.1.1. 将对象中的成员变量替换为Mock/Spy对象公共方法
        1.1.2. 获取Mock对象原始类型及默认Answer等详细信息
        1.1.3. 获取Mock对象的Stub设置及方法调用情况
    1.2. 使用@InjectMocks注解实现Mock/Spy对象的自动注入
        1.2.1. 不推荐使用@InjectMocks注解
    1.3. MockitoAnnotations.initMocks()方法
    1.4. Mockito.reset()方法
    1.5. Mockito的Stub操作支持的对象
    1.6. 获取私有成员变量
        1.6.1. 检查对象字段值是否等于预期值的简化方法
    1.7. 替换私有成员变量
    1.8. 创建构造函数为私有的类的实例
    1.9. 执行私有方法
2. 使用Mock禁止Spring定时任务
```

- 20.Mock相关总结

```
1. 单元测试Mock代码编写建议
2. 单元测试Mock相关总结
    2.1. 对Spring的@Component组件进行部分Mock
    2.2. Mock相关方法分类
    2.3. Mock相关方法对比
    2.4. 不同情况可用的Mock方法对比
        2.4.1. 静态方法
            2.4.1.1. 静态公有非void方法
            2.4.1.2. 静态公有void方法/私有方法
            2.4.1.3. 静态代码块
        2.4.2. 所有实例的非静态方法
        2.4.3. 指定的Mock对象非静态方法
            2.4.3.1. Mock对象非静态公有非void方法
            2.4.3.2. Mock对象非静态公有void方法
            2.4.3.3. Mock对象非静态私有方法
        2.4.4. 指定的Spy对象非静态方法
            2.4.4.1. Spy对象非静态公有方法
            2.4.4.2. Spy对象非静态私有方法
    2.5. 常见Mock场景总结
        2.5.1. Mock远程服务调用
        2.5.2. 从数据库或文件读取数据
        2.5.3. 跳过检查操作
        2.5.4. 跳过AOP处理
        2.5.5. 检查特定方法是否执行/调用参数
        2.5.6. 禁止特定方法执行
    2.6. 使用Mockito、PowerMock容易出现的问题总结
```

- 21.使用Gradle执行单元测试

```
1. 使用Gradle执行单元测试
    1.1. Gradle test任务
    1.2. 使用Gradle Wrapper
        1.2.1. 添加Gradle Wrapper
        1.2.2. 通过Gradle Wrapper执行Gradle任务
    1.3. Gradle test任务依赖的任务
        1.3.1. 查看Gradle test任务依赖的任务
        1.3.2. Gradle test任务依赖的任务说明
    1.4. Gradle执行test任务时的相关进程
        1.4.1. GradleDaemon进程
        1.4.2. GradleMain/GradleWrapperMain进程
        1.4.3. GradleWorkerMain进程
    1.5. Gradle build任务排除test任务
    1.6. 测试类过滤
    1.7. 测试类检测
    1.8. 并发执行测试
```

- 22.Gradle资源文件与配置参数动态替换

```
1. Gradle资源文件与配置参数动态替换
    1.1. main模块与test模块资源文件
        1.1.1. 输入输出文件
        1.1.2. Gradle test任务执行时使用的资源文件
        1.1.3. test模块资源文件设置
    1.2. Gradle脚本动态替换配置参数
        1.2.1. 适用场景
        1.2.2. 在filter中使用ReplaceTokens
        1.2.3. 使用ConfigSlurper读取Groovy配置文件
        1.2.4. 使用自定义标识符
        1.2.5. 配置文件中文乱码问题
        1.2.6. 示例项目配置文件使用
        1.2.7. 获取Groovy配置文件参数值
            1.2.7.1. Groovy特殊字符转义
        1.2.8. 测试范围设置
    1.3. 根据Gradle执行的任务改变操作
        1.3.1. 解决processResources任务导致找不到资源文件的问题
```

- 23.Gradle单元测试日志、报告与JaCoCo代码覆盖率

```
1. Gradle单元测试日志、报告与JaCoCo代码覆盖率
    1.1. Gradle单元测试日志
    1.2. 生成测试报告
    1.3. 使用JaCoCo生成代码覆盖率报告
        1.3.1. jacocoTestReport任务
        1.3.2. 执行测试时生成代码覆盖率报告
            1.3.2.1. 执行测试失败时生成代码覆盖率报告
        1.3.3. 指定生成覆盖率报告的代码类范围
        1.3.4. 覆盖率报告显示代码中文乱码问题
```

- 24.Gradle执行test任务卡死问题解决

```
1. Gradle执行test任务卡死问题解决
    1.1. test任务卡死问题现象
        1.1.1. 无效的解决方法
        1.1.2. 与Gradle版本的关系
        1.1.3. 测试结束后关闭数据库连接池
        1.1.4. 修改SoftRefLRUPolicyMSPerMB参数
    1.2. test任务卡死问题解决过程
        1.2.1. 查看内存与GC情况
        1.2.2. 调整Metaspace参数
            1.2.2.1. Metaspace相关
            1.2.2.2. 限制Metaspace大小
        1.2.3. 设置Gradle执行test任务使用新进程
    1.3. 解决Gradle执行test任务卡死方法总结
    1.4. Gradle执行test任务内存溢出问题分析
        1.4.1. Metaspace内存溢出示例
        1.4.2. Gradle执行test任务Metaspace内存溢出问题原因
        1.4.3. PowerMockito内存泄露问题
```

- 25.在本地使用H2数据库进行单元测试

```
1. 前言
3. H2数据库介绍
    3.1. 以嵌入模式使用H2数据库
    3.2. H2数据库与其他数据库的兼容性
        3.2.1. MySQL兼容模式
    3.3. 数据库URL连接模式与设置
        3.3.1. 嵌入（本地）模式连接
        3.3.2. 内存数据库
        3.3.3. 在连接数据库时执行SQL
            3.3.3.1. RUNSCRIPT命令
    3.4. H2数据库文件信息
    3.5. 支持H2的数据库管理工具
        3.5.1. H2
        3.5.2. SQuirreL SQL
4. 在单元测试中使用H2嵌入（本地）模式
    4.1. 指定数据库建表语句
    4.2. 数据库连接参数
    4.3. 建表语句注意事项
    4.4. 测试类注意事项
        4.4.1. 测试类结束后关闭数据源
        4.4.2. 测试类需要重新加载Spring Context
    4.5. 创建并设置SCHEMA
    4.6. 使用数据库工具打开数据库文件
        4.6.1. 使用H2
        4.6.2. 使用SQuirreL SQL
5. 在单元测试中使用H2内存数据库模式
    5.1. 数据库连接URL参数
6. H2与MySQL对比
    6.1. 时间字段对比
    6.2. update语句返回行数
    6.3. 关闭数据源
    6.4. H2与MySQL语句对比
        6.4.1. insert ignore
        6.4.2. insert on duplicate key update
        6.4.3. replace into
        6.4.4. SQL语句对比结果
```

- 26.使用JPA自动创建数据库表

```
1. 使用JPA自动创建数据库表
    1.1. JPA相关
        1.1.1. 生成JAP Entity
        1.1.2. EntityManager
        1.1.3. EntityManagerFactory
        1.1.4. JPA自动建表参数配置
        1.1.5. 自动建表时打印SQL语句
        1.1.6. hibernate依赖组件
        1.1.7. Spring JPA配置
            1.1.7.1. Spring JPA
            1.1.7.2. JpaVendorAdapter
            1.1.7.3. LocalContainerEntityManagerFactoryBean
    1.2. JPA自动建表总结
    1.3. JPA自动建表配置
        1.3.1. 添加依赖
        1.3.2. Spring XML配置
        1.3.3. H2数据库连接参数
            1.3.3.1. 使用H2嵌入（本地）模式
            1.3.3.2. 使用H2内存数据库模式
    1.4. JPA自动建表的时间类型
    1.5. 指定JPA自动建表的字段定义
```

- 27.JPA Entity生成工具Java组件增强版

```
1. 前言
2. 优化范围
3. 使用说明
    3.1. 执行方式
        3.1.1. Gradle插件方式（原有）
        3.1.2. Maven插件方式（原有）
        3.1.3. 通过测试类执行（新增）
    3.2. 配置文件参数（原有）
    3.3. 修改字段类型（新增）
4. 相关资料
    4.1. JPA相关
        4.1.1. Entity相关
    4.2. hibernate JPA实现
        4.2.1. Lob字段
        4.2.2. 依赖组件
```

- 28.spring-test数据库操作自动回滚处理

```
1. spring-test数据库操作自动回滚处理
    1.1. spring-test提供的事务相关类与注解
        1.1.1. AbstractTransactionalJUnit4SpringContextTests类
        1.1.2. TransactionalTestExecutionListener类
        1.1.3. @Rollback注解
        1.1.4. @Commit注解
    1.2. 使数据库操作使用事务自动回滚的配置
        1.2.1. 配置TransactionalTestExecutionListener
        1.2.2. 配置@Rollback注解
    1.3. 使数据库操作使用事务最终提交的配置
        1.3.1. 配置TransactionalTestExecutionListener
        1.3.2. 配置@Commit注解
    1.4. 单元测试使用事务时的相关日志
    1.5. 测试代码与被测试代码均使用事务时的冲突
    1.6. 未出现异常时回滚，出现异常时不回滚的优化处理
    1.7. spring-test事务处理相关代码分析
        1.7.1. 是否回滚默认标志初始化
        1.7.2. 当前测试方法是否需要使用事务判断
        1.7.3. 当前测试方法的事务是否回滚标志初始化
        1.7.4. 当前测试方法的事务是否回滚标志修改
        1.7.5. 结束事务时回滚还是提交的判断
```

- Spring MVC 单元测试
未完待续