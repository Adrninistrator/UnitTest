package test.testframework.junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

//指定测试方法以字典顺序执行
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnitOrder1 {

    private static List<Integer> list = new ArrayList(3);

    @Test
    public void test1() {
        list.add(1);
    }

    @Test
    public void test2() {
        list.add(2);
    }

    @Test
    public void test3() {
        list.add(3);
    }

    @AfterClass
    public static void afterClass() {

        Assert.assertEquals(3, list.size());

        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
    }
}
