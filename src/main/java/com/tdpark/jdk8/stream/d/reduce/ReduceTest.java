package com.tdpark.jdk8.stream.d.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tdpark.jdk8.stream.Student;


/**
 * 类ReduceTest.java的实现描述：集合流计算测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午3:01:10
 */
public class ReduceTest {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("赵", 88), new Student("钱", 68), new Student("孙", 55),
                new Student("李", 81), new Student("周", 38), new Student("吴", 60), new Student("郑", 95), new Student(
                        "王", 100));
        Optional<Integer> o1 = list.stream().map(Student::getScore).reduce(Math::max);
        System.out.println(o1.get());
        Optional<Integer> o2 = list.stream().map(Student::getScore).reduce(Integer::max);
        System.out.println(o2.get());
        Optional<Integer> o3 = list.stream().map(Student::getScore).reduce((i1, i2) -> Math.min(i1, i2));
        System.out.println(o3.get());

    }
}
