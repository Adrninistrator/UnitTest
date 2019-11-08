package test.common;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.core.MockGateway;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class TestCommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestCommonUtil.class);

    //Mockito版本是否为新版
    private static Boolean mockitoNew;

    //PowerMock版本是否为最新版
    private static Boolean powerMockNewest;

    //获取InvocationOnMock的指定序号的参数值
    public static <T> T getMockArg(InvocationOnMock invocation, int index, Class<T> clazz) throws Exception {

        String className = invocation.getClass().getName();

        if (isMockitoNew()) {
            //Mockito为新版，调用InterceptedInvocation.getArgument(int index)方法

            logger.info("Mockito为新版，className: {} 使用InterceptedInvocation.getArgument", className);

            return Whitebox.invokeMethod(invocation, "getArgument", index);
        }
        //Mockito为旧版，调用InvocationImpl.getArgumentAt(int index, Class<T> clazz)方法

        logger.info("Mockito为旧版，className: {}使用InvocationImpl.getArgumentAt", className);

        return Whitebox.invokeMethod(invocation, "getArgumentAt", index, clazz);
    }

    //返回Mockito版本是否为新版
    public static boolean isMockitoNew() {

        if (mockitoNew != null) {
            return mockitoNew.booleanValue();
        }

        String mockitoJarPath = Mockito.class.getProtectionDomain().getCodeSource().getLocation().toString();
        /*
            示例
            file:/E:/gradle-dir/caches/modules-2/files-2.1/org
            .mockito/mockito-core/1.10.19/e8546f5bef4e061d8dd73895b4e8f40e3fe6effe/mockito-core-1.10.19.jar
         */
        logger.info("mockitoJarPath: {}", mockitoJarPath);

        File jarFile = new File(mockitoJarPath);

        String mockitoFileName = jarFile.getName().toLowerCase();

        logger.info("mockitoFileName: {}", mockitoFileName);

        //与旧版Mockito的jar包名字比较
        if (mockitoFileName.compareTo(TestConstants.MOCKITO_JAR_NAME_OLD) > 0) {
            //大于旧版Mockito的jar包名字，认定使用旧版Mockito

            logger.info("Mockito为新版");
            mockitoNew = Boolean.TRUE;
            return true;
        }

        //小于等于旧版Mockito的jar包名字，认定使用旧版Mockito

        logger.info("Mockito为旧版");
        mockitoNew = Boolean.FALSE;
        return false;
    }

    //返回PowerMock版本是否为最新版
    public static boolean isPowerMockNewest() {

        if (powerMockNewest != null) {
            return powerMockNewest.booleanValue();
        }

        String powerMockJarPath = MockGateway.class.getProtectionDomain().getCodeSource().getLocation().toString();
        /*
            示例
            file:/E:/gradle-dir/caches/modules-2/files-2.1/org
            .powermock/powermock-core/1.6.6/8085fae46f60d7ff960f1cc711359c00b35c5887/powermock-core-1.6.6.jar
         */
        logger.info("powerMockJarPath: {}", powerMockJarPath);

        File jarFile = new File(powerMockJarPath);

        String powerMockFileName = jarFile.getName().toLowerCase();

        logger.info("powerMockFileName: {}", powerMockFileName);

        //与最新版PowerMock的jar包名字比较
        if (powerMockFileName.compareTo(TestConstants.POWERMOCK_JAR_NAME_NEWEST) >= 0) {
            //大于等于最版PowerMock的jar包名字，认定使用最新版PowerMock

            logger.info("PowerMock为最新版");
            powerMockNewest = Boolean.TRUE;
            return true;
        }

        //小于最新版powerMock的jar包名字，认定使用不是最新版PowerMock

        logger.info("PowerMock不是最新版");
        powerMockNewest = Boolean.FALSE;
        return false;
    }

    public static void compareObj(Object object1, Object object2, boolean equals) {

        long hashCode1 = System.identityHashCode(object1);
        long hashCode2 = System.identityHashCode(object2);

        logger.info("hashCode1: {} hashCode2: {}", hashCode1, hashCode2);

        if (equals) {
            Assert.assertEquals(hashCode1, hashCode2);
        } else {
            Assert.assertNotEquals(hashCode1, hashCode2);
        }
    }

    public static void printStack(Throwable throwable, String description) {

        if (throwable == null) {
            logger.info("{} is null", description);

            return;
        }

        logger.info("\r\n{} Throwable Class: {}\r\nMessage: {}", description, throwable.getClass(), throwable
                .getMessage());

        StackTraceElement[] stackTraceElements = throwable.getStackTrace();

        if (stackTraceElements != null && stackTraceElements.length > 0) {

            StringBuilder stringBuilder = new StringBuilder(description).append(" stack trace:");

            for (StackTraceElement stackTraceElement : stackTraceElements) {
                stringBuilder.append("\r\n\t").append(stackTraceElement);
            }

            logger.info("{}", stringBuilder);
        }
    }

    private TestCommonUtil() {
        throw new IllegalStateException("illegal");
    }
}
