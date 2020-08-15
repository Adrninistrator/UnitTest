package com.adrninistrator.util;

import com.adrninistrator.common.constants.TestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    记录及获取指定方法的调用次数工具类
    注意：1.非线程安全，2.同一个类中的方法不要同名
 */
public class TestCallTimesUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestCallTimesUtil.class);

    private static Map<String, Integer> callTimesMap = new HashMap<>();

    // 记录对应方法的调用次数
    public static void addCallTimes() {
        // 获取调用方法堆栈元素
        StackTraceElement stackTraceElement = getCallStackElement(TestCallTimesUtil.class, "addCallTimes");

        String key = stackTraceElement.getClassName() + TestConstants.DOLOR + stackTraceElement.getMethodName();

        Integer value = callTimesMap.get(key);

        Integer valueBefore;
        Integer valueAfter;

        if (value == null) {
            valueBefore = 0;
            valueAfter = 1;
        } else {
            valueBefore = value;
            valueAfter = value + 1;
        }

        callTimesMap.put(key, valueAfter);

        logger.info("{} addCallTimes {}->{}", key, valueBefore, valueAfter);
    }

    /**
     * 获取调用方法堆栈元素
     *
     * @Param clazz，被调用方法的类
     * @Param methodName，被调用的方法名称
     */
    public static StackTraceElement getCallStackElement(Class clazz, String methodName) {
        // 获取调用堆栈
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        int stackTraceElementLen = stackTraceElements.length;

        // 记录调用方法的元素下标
        int elementIndex = 0;

        // 找到调用当前方法的元素下标
        for (int i = 0; i < stackTraceElementLen; i++) {
            if (clazz.getName().equals(stackTraceElements[i].getClassName()) && methodName
                    .equals(stackTraceElements[i].getMethodName())) {
                elementIndex = i + 1;
                break;
            }
        }

        // 返回下一个元素信息
        return stackTraceElements[elementIndex];
    }

    /*
        清空调用该方法的方法的调用次数为0
        @Param clazz，指定的类
        @Param methodName，指定的方法
     */
    public static void clearCallTimes(Class clazz, String methodName) {
        String key = clazz.getName() + TestConstants.DOLOR + methodName;

        callTimesMap.put(key, 0);

        logger.info("{} clearCallTimes", key);
    }

    /*
        获取指定方法的调用次数
        @Param clazz，指定的类
        @Param methodName，指定的方法
     */
    public static int getCallTimes(Class clazz, String methodName) {
        String key = clazz.getName() + TestConstants.DOLOR + methodName;

        Integer value = callTimesMap.get(key);

        int callTimes = 0;

        if (value != null) {
            callTimes = value;
        }

        logger.info("{} callTimes: {}", key, callTimes);

        return callTimes;
    }

    private TestCallTimesUtil() {
        throw new IllegalStateException("illegal");
    }
}
