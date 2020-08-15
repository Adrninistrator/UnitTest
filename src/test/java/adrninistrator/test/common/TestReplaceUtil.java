package adrninistrator.test.common;

import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.fail;

public class TestReplaceUtil {

    /**
     * 将对象object中的指定类型clazz成员变量替换为Mock对象并返回，简化操作，避免将现有Mock对象的Stub操作丢弃。
     *
     * @param object 需要替换成员变量的对象
     * @param clazz  需要被替换的成员变量的类型
     * @return 需要被替换的成员变量对应的Mock对象
     */
    public static <T> T replaceMockMember(Object object, Class<T> clazz) {
        // 获取对象中的成员变量
        T member = Whitebox.getInternalState(object, clazz);
        if (member == null) {
            fail("获取成员变量为空");
        }

        MockingDetails mockingDetails = Mockito.mockingDetails(member);

        // 若成员变量为Mock对象，则直接返回
        if (mockingDetails.isMock()) {
            return member;
        }

        // 若成员变量为Spy对象，则抛出异常
        if (mockingDetails.isSpy()) {
            fail("成员变量为Spy对象");
        }

        // 成员变量是原始对象

        // 生成Mock对象
        T mockMember = Mockito.mock(clazz);

        // 将成员变量替换为Mock对象
        Whitebox.setInternalState(object, mockMember);

        return mockMember;
    }

    /**
     * 将对象object中的指定类型clazz成员变量替换为Spy对象并返回，简化操作，避免将现有Spy对象的Stub操作丢弃。
     *
     * @param object 需要替换成员变量的对象
     * @param clazz  需要被替换的成员变量的类型
     * @return 需要被替换的成员变量对应的Spy对象
     */
    public static <T> T replaceSpyMember(Object object, Class<T> clazz) {
        // 获取对象中的成员变量
        T member = Whitebox.getInternalState(object, clazz);
        if (member == null) {
            fail("获取成员变量为空");
        }

        MockingDetails mockingDetails = Mockito.mockingDetails(member);

        // 若成员变量为Spy对象，则直接返回
        if (mockingDetails.isSpy()) {
            return member;
        }

        // 若成员变量为Mock对象，则抛出异常
        if (mockingDetails.isMock()) {
            fail("成员变量为Mock对象");
        }

        // 成员变量是原始对象

        // 生成Spy对象
        T mockMember = Mockito.spy(member);

        // 将成员变量替换为Spy对象
        Whitebox.setInternalState(object, mockMember);

        return mockMember;
    }


    private TestReplaceUtil() {
        throw new IllegalStateException("illegal");
    }
}
