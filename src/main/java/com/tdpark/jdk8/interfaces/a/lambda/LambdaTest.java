package com.tdpark.jdk8.interfaces.a.lambda;

import com.tdpark.jdk8.PrintUtils;


/**
 * 类LambdaTest.java的实现描述：Lambda测试类
 * 
 * @author jiangyongsheng 2019年3月26日 上午10:20:40
 */
public class LambdaTest {

    public static void main(String[] args) {
        //实现类
        Cat cat = new WhiteCat();
        cat.color();
        //匿名内部类
        cat = new Cat() {
            @Override
            public void color() {
                System.out.println("black cat!");
            }
        };
        cat.color();
        //Lambda表达式【接口只能有一个未实现的方法】,当方法体只有一行时大括号可以省略
        cat = () -> {
            System.out.println("yellow cat!");
        };
        cat.color();
        System.out.println(cat.getClass());
        PrintUtils.split();
        //当方法体只有一行时大括号和return都可以省略
        Dog dog = () -> "yellow dog";
        System.out.println(dog.color());
        PrintUtils.split();
        Monkey monkey = (color, thing) -> color + " monkey eat " + thing;
        System.out.println(monkey.eat("white", "banana"));
    }
}

/**
 * 类Cat.java的实现描述：只有一个未实现的方法[无返回值]的接口
 * 
 * @author jiangyongsheng 2019年3月26日 上午10:27:05
 */
@FunctionalInterface
interface Cat {
    void color();
}

class WhiteCat implements Cat {

    @Override
    public void color() {
        System.out.println("white cat!");
    }
}

/**
 * 类Dog.java的实现描述：只有一个未实现的方法[有返回值]的接口
 * 
 * @author jiangyongsheng 2019年3月26日 上午10:27:05
 */
@FunctionalInterface
interface Dog {
    String color();
}

/**
 * 类Monkey.java的实现描述：只有一个未实现的方法[有参数和返回值]的接口
 * 
 * @author jiangyongsheng 2019年3月26日 上午10:27:05
 */
@FunctionalInterface
interface Monkey {
    String eat(String color, String thing);
}
