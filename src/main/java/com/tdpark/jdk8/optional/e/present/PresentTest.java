package com.tdpark.jdk8.optional.e.present;

import java.util.Optional;

import com.tdpark.jdk8.optional.Teacher;


/**
 * 类PresentTeset.java的实现描述：空值处理测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午6:23:46
 */
public class PresentTest {

    public static void main(String[] args) {

        Optional<Teacher> optional = Optional.ofNullable(null);
        //是否有值
        System.out.println(optional.isPresent());
        //如果有值的话则执行括号里面的方法
        optional.ifPresent(System.out::print);
        optional = Optional.ofNullable(new Teacher("赵", 40));
        System.out.println(optional.isPresent());
        optional.ifPresent(System.out::print);
    }
}
