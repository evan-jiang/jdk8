package com.tdpark.jdk8.interfaces.c.staticmethod;

/**
 * 类StaticMethodTest.java的实现描述：接口静态方法测试类
 * 
 * @author jiangyongsheng 2019年3月27日 上午9:44:36
 */
public class StaticMethodTest {

    public static void main(String[] args) {
        Bear bear = () -> "black";
        System.out.println(bear.defColor() + " tiger");
        System.out.println(Bear.staticMethod());

    }
}

@FunctionalInterface
interface Bear {

    String YELLOW  = "yellow";
    String UNKNOWN = "unknown";

    String color();

    //Object 的方法除外
    String toString();

    default String defColor() {
        String color = color();
        if (color == null || color.trim().length() == 0 || color.equalsIgnoreCase(UNKNOWN)) {
            color = YELLOW;
        }
        return color;
    }

    //支持静态方法
    public static String staticMethod() {
        return "this is static method!!";
    }

}
