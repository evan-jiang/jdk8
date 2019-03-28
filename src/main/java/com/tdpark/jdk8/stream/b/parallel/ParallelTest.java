package com.tdpark.jdk8.stream.b.parallel;

import java.util.Arrays;
import java.util.List;

import com.tdpark.jdk8.PrintUtils;
import com.tdpark.jdk8.stream.Student;


/**
 * 类ParallelTest.java的实现描述：集合并行流测试类
 * 
 * @author jiangyongsheng 2019年3月27日 下午2:59:21
 */
public class ParallelTest {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("赵", 88), new Student("钱", 68), new Student("孙", 55),
                new Student("李", 81), new Student("周", 38), new Student("吴", 60), new Student("郑", 95), new Student(
                        "王", 100));
        //串行流
        list.stream().forEach(System.out::print);
        PrintUtils.split();
        //并行流
        list.parallelStream().forEach(System.out::print);
    }
}
