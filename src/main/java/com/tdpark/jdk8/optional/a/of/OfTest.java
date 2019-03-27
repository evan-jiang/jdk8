package com.tdpark.jdk8.optional.a.of;

import java.util.Optional;

import com.tdpark.jdk8.optional.Teacher;


/**
 * 类OfTest.java的实现描述：初始化测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午5:29:29
 */
public class OfTest {
    public static void main(String[] args) {
        Optional<Teacher> optional = null;
        //空指针异常
        try {
            optional = Optional.of(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        optional = Optional.of(new Teacher("赵", 40));
        //不会报空指针
        optional = Optional.ofNullable(null);
        optional = Optional.ofNullable(new Teacher("赵", 40));
        System.out.println(optional.get());
    }
}
