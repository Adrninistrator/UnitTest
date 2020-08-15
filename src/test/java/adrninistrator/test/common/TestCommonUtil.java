package adrninistrator.test.common;

import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.core.MockGateway;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class TestCommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestCommonUtil.class);

    // Mockito版本是否为新版
    private static Boolean mockitoNew;

    // PowerMock版本是否为最新版
    private static Boolean powerMockNewest;

    // 获取InvocationOnMock的指定序号的参数值
    public static <T> T getMockArg(InvocationOnMock invocation, int index, Class<T> clazz) throws Exception {

        String className = invocation.getClass().getName();

        if (isMockitoNew()) {
            // Mockito为新版，调用InterceptedInvocation.getArgument(int index)方法

            logger.info("Mockito为新版，className: {} 使用InterceptedInvocation.getArgument", className);

            return Whitebox.invokeMethod(invocation, "getArgument", index);
        }
        // Mockito为旧版，调用InvocationImpl.getArgumentAt(int index, Class<T> clazz)方法

        logger.info("Mockito为旧版，className: {}使用InvocationImpl.getArgumentAt", className);

        return Whitebox.invokeMethod(invocation, "getArgumentAt", index, clazz);
    }

    // 返回Mockito版本是否为新版
    public static boolean isMockitoNew() {
        if (mockitoNew != null) {
            return mockitoNew.booleanValue();
        }

        String mockitoJarPath = Mockito.class.getProtectionDomain().getCodeSource().getLocation().toString();
        /*
            示例
            file:/D:/gradle-local/caches/modules-2/files-2.1/org
            .mockito/mockito-core/1.10.19/e8546f5bef4e061d8dd73895b4e8f40e3fe6effe/mockito-core-1.10.19.jar
         */
        logger.info("mockitoJarPath: {}", mockitoJarPath);

        File jarFile = new File(mockitoJarPath);

        String mockitoFileName = jarFile.getName().toLowerCase();

        logger.info("mockitoFileName: {}", mockitoFileName);

        // 与旧版Mockito的jar包名字比较
        if (mockitoFileName.compareTo(TestConstants.MOCKITO_JAR_NAME_OLD) > 0) {
            // 大于旧版Mockito的jar包名字，认定使用旧版Mockito

            logger.info("Mockito为新版");
            mockitoNew = Boolean.TRUE;
            return true;
        }

        // 小于等于旧版Mockito的jar包名字，认定使用旧版Mockito

        logger.info("Mockito为旧版");
        mockitoNew = Boolean.FALSE;
        return false;
    }

    // 返回PowerMock版本是否为最新版
    public static boolean isPowerMockNew() {
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

        // 与最新版PowerMock的jar包名字比较
        if (powerMockFileName.compareTo(TestConstants.POWERMOCK_JAR_NAME_NEW) >= 0) {
            // 大于等于最版PowerMock的jar包名字，认定使用最新版PowerMock

            logger.info("PowerMock为最新版");
            powerMockNewest = Boolean.TRUE;
            return true;
        }

        // 小于最新版powerMock的jar包名字，认定使用不是最新版PowerMock

        logger.info("PowerMock不是最新版");
        powerMockNewest = Boolean.FALSE;
        return false;
    }

    // 获取指定测试类的@Test方法数量（包含超类中的方法）
    public static int getTestNum(Class clazz) {
        int num = 0;

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (isNotTestMethod(method)) {
                continue;
            }

            Test testAnnotation = AnnotationUtils.findAnnotation(method, Test.class);
            if (testAnnotation != null) {
                num++;
            }
        }

        return num;
    }

    /**
     * 判断是否非@Test对应方法
     *
     * @param method
     * @return true：非@Test对应方法，false：可能为@Test对应方法
     */
    public static boolean isNotTestMethod(Method method) {
        // @Test对应方法需要满足public，void，非staic
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers) || Modifier.isStatic(modifiers)) {
            return true;
        }

        Class<?> returnType = method.getReturnType();

        return returnType != Void.TYPE;
    }

    /**
     * 检查对象字段值是否等于预期值的简化方法
     * 判断obj对象中的字段值是否满足keyValues指定的条件
     * 支持对字符串、int、long、BigDecimal、Date等类型进行比较
     *
     * @param obj
     * @param keyValues 需要检查的信息，元素应为偶数个，下标为奇数的元素为key，下标为偶数的元素为value
     */
    public static void checkObjectValue(Object obj, Object[] keyValues) {
        if (keyValues.length % 2 != 0) {
            fail(obj.getClass().getSimpleName() + "-元素个数不是偶数 " + keyValues.length);
        }

        int length = keyValues.length / 2;

        for (int i = 0; i < length; i++) {
            if (!(keyValues[2 * i] instanceof String)) {
                fail(obj.getClass().getSimpleName() + "-元素类型不是String " + 2 * i);
            }

            String key = (String) keyValues[2 * i];

            Object expectedValue = keyValues[2 * i + 1];
            Object value = Whitebox.getInternalState(obj, key);

            logger.info("class: {} key: {}, expectedValue: {}, value: {}", obj.getClass().getSimpleName(), key, expectedValue, value);

            if (value != null) {
                checkEquals(obj, key, expectedValue, value);
            } else {
                assertNull(obj.getClass().getSimpleName() + "-" + key, expectedValue);
            }
        }
    }

    /**
     * 判断value是否等于expectedValue，若不相等时，提示信息中包含obj对应的类名，及value对应的字段名key
     *
     * @param obj
     * @param key
     * @param expectedValue
     * @param value
     */
    public static void checkEquals(Object obj, String key, Object expectedValue, Object value) {
        if (expectedValue instanceof BigDecimal && value instanceof BigDecimal) {
            assertEquals(obj.getClass().getSimpleName() + "-" + key, 0, ((BigDecimal) expectedValue).compareTo((BigDecimal) value));
            return;
        }

        if (expectedValue instanceof Date && value instanceof Date) {
            assertTrue(obj.getClass().getSimpleName() + "-" + key, ((Date) expectedValue).getTime() == ((Date) value).getTime());
            return;
        }

        assertEquals(obj.getClass().getSimpleName() + "-" + key, expectedValue, value);
    }

    private TestCommonUtil() {
        throw new IllegalStateException("illegal");
    }
}
