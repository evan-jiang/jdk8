package com.tdpark.jdk8.optional.b.get;

import java.util.Optional;

import com.tdpark.jdk8.PrintUtils;
import com.tdpark.jdk8.optional.Teacher;


/**
 * 类GetTest.java的实现描述：获取值测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午5:41:59
 */
public class GetTest {

    public static void main(String[] args) throws InterruptedException {
        Optional<Teacher> optional = Optional.ofNullable(new Teacher("赵", 40));
        System.out.println(optional.get());
        System.out.println(optional.orElse(null));
        System.out.println(optional.orElseGet(Teacher::new));
        System.out.println(optional.orElseThrow(IllegalArgumentException::new));
        PrintUtils.split();
        //设置一个空值的Optional
        optional = Optional.ofNullable(null);
        Thread.sleep(100L);
        try {
            //没有值就会抛异常 NoSuchElementException
            System.out.println(optional.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(100L);
        //没有值就选括号里面的值
        System.out.println(optional.orElse(null));
        //没有值就选括号里面的值，构造方法一定会执行
        System.out.println(optional.orElse(new Teacher()));
        //没有值就构造一个值，构造方法不一定会执行
        System.out.println(optional.orElseGet(Teacher::new));
        Thread.sleep(100L);
        try {
            //没有值就构造一个异常
            System.out.println(optional.orElseThrow(IllegalArgumentException::new));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
