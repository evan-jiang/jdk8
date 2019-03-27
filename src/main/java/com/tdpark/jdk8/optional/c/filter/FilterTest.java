package com.tdpark.jdk8.optional.c.filter;

import java.util.Optional;

import com.tdpark.jdk8.optional.Teacher;


/**
 * 类FilterTest.java的实现描述：过滤测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午5:57:41
 */
public class FilterTest {

    public static void main(String[] args) {
        Optional<Teacher> optional = Optional.ofNullable(new Teacher("赵", 40));
        optional = optional.filter((t) -> t.getAge() < 30);
        System.out.println(optional.get());
    }
}
