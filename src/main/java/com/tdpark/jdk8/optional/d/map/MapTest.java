package com.tdpark.jdk8.optional.d.map;

import java.util.Optional;

import com.tdpark.jdk8.optional.Teacher;


/**
 * 类MapTest.java的实现描述：映射测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午6:03:27
 */
public class MapTest {

    public static void main(String[] args) {

        Optional<Teacher> optional = Optional.ofNullable(new Teacher("赵", 40));
        //映射出name,传入参数不需要Optional类,传入参数可空
        Optional<String> map = optional.map(Teacher::getName);
        System.out.println(map.orElse(null));
        //映射出name,传入参数必须要Optional类,Optional不可为空,Optional里面的值可以为空
        map = optional.flatMap(t -> Optional.ofNullable(t.getName()));
        System.out.println(map.orElse(null));
        //正常
        map = optional.map(t -> null);
        System.out.println(map.orElse(null));
        //正常
        map = optional.flatMap(t -> Optional.empty());
        System.out.println(map.orElse(null));
        //异常
        map = optional.flatMap(t -> null);
        System.out.println(map.orElse(null));
    }
}
