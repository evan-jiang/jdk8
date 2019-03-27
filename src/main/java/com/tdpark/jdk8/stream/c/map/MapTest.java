package com.tdpark.jdk8.stream.c.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tdpark.jdk8.PrintUtils;
import com.tdpark.jdk8.stream.Student;


/**
 * 类MapTest.java的实现描述：集合流映射测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午2:59:45
 */
public class MapTest {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("赵", 88), new Student("钱", 68), new Student("孙", 55),
                new Student("李", 81), new Student("周", 38), new Student("吴", 60), new Student("郑", 95), new Student(
                        "王", 100));
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        List<Integer> scores = list.stream().map(Student::getScore).collect(Collectors.toList());
        List<String> levels = list.stream().map((s) -> convert(s.getScore())).collect(Collectors.toList());
        System.out.println(list);
        PrintUtils.split();
        System.out.println(names);
        PrintUtils.split();
        System.out.println(scores);
        PrintUtils.split();
        System.out.println(levels);
    }

    public static String convert(Integer score) {
        if (score >= 90) {
            return "S";
        }
        if (score >= 80) {
            return "A";
        }
        if (score >= 70) {
            return "B";
        }
        if (score >= 60) {
            return "C";
        }
        return "D";
    }
}
