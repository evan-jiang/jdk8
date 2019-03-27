package com.tdpark.jdk8.stream.a.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.tdpark.jdk8.PrintUtils;
import com.tdpark.jdk8.stream.Student;


/**
 * 类GeneralTest.java的实现描述：集合流测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午2:36:18
 */
public class GeneralTest {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("赵", 88), new Student("钱", 68), new Student("孙", 55),
                new Student("李", 81), new Student("周", 38), new Student("吴", 60), new Student("郑", 95), new Student(
                        "王", 100));

        //筛选90分及以上的同学，升序
        List<Student> result = new ArrayList<Student>();
        for (Student s : list) {
            if (s.getScore() >= 90) {
                result.add(s);
            }
        }
        Collections.sort(result, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        System.out.println(result);
        PrintUtils.split();

        //筛选60分及以上的同学，升序
        result = list.stream().filter(new Predicate<Student>() {

            @Override
            public boolean test(Student t) {
                return t.getScore() >= 60;
            }
        }).sorted(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                //倒序
                return Integer.compare(o1.getScore(), o2.getScore());
            }
        }).collect(Collectors.toList());
        System.out.println(result);

        PrintUtils.split();
        //筛选66分及以上的同学，倒序
        result = list.stream().filter((s) -> s.getScore() >= 66)
        //Lambda
        //.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
        //方法引用
                .sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        System.out.println(result);
    }
}
