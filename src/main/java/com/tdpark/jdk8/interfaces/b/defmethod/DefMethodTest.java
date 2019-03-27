package com.tdpark.jdk8.interfaces.b.defmethod;

/**
 * 类InterfaceDefMethodTest.java的实现描述：接口默认方法测试类
 * 
 * @author jiangyongsheng 2019年3月26日 上午11:02:21
 */
public class DefMethodTest {

    public static void main(String[] args) {
        Fox fox = () -> "";
        System.out.println(fox.defColor() + " fox");
        fox = () -> "white";
        System.out.println(fox.defColor() + " fox");
    }
}

/**
 * 类Fox.java的实现描述： 含有默认方法的接口
 * 
 * @author jiangyongsheng 2019年3月26日 上午11:02:47
 */
@FunctionalInterface
interface Fox {
    String color();

    /**
     * 默认方法
     * 
     * @return
     */
    default String defColor() {
        String color = color();
        if (color == null || color.trim().length() == 0 || color.equalsIgnoreCase("unknown")) {
            color = "yellow";
        }
        return color;
    }
}
