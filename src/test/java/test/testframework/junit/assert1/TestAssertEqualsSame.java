package test.testframework.junit.assert1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.common.TestCommonUtil;

/*
    Assert.assertEquals/Assert.assertNotEquals：判断对象的值是否相同/不同
    Assert.assertSame/Assert.assertNotSame：判断是否是/不是同一个对象
 */
public class TestAssertEqualsSame {

    private Integer integer1 = Integer.valueOf(10000);

    private Integer integer2 = Integer.valueOf(10000);

    private Integer integer3 = integer1;

    @Before
    public void init() {

        TestCommonUtil.compareObj(integer1, integer2, false);

        TestCommonUtil.compareObj(integer1, integer3, true);
    }

    @Test
    public void test() {

        //需要使用大于127的数字，否则Integer会有缓存
        Assert.assertEquals(integer1, integer2);

        Assert.assertNotSame(integer1, integer2);

        Assert.assertEquals(integer1, integer3);

        Assert.assertSame(integer1, integer3);
    }
}
