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
        PrintUtils.split();
        int total = 50000000;
        long start = System.currentTimeMillis();
        for (int idx = 0; idx < total; idx++) {
            filter1(list);
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        for (int idx = 0; idx < total; idx++) {
            //并行流在做过滤的时候比串行流快
            filter2(list);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 串行流过滤
     * 
     * @param list
     */
    public static void filter1(List<Student> list) {
        list.stream().filter((s) -> {
            return true;
        });
    }

    /**
     * 并行流过滤
     * 
     * @param list
     */
    public static void filter2(List<Student> list) {
        list.parallelStream().filter((s) -> {
            return true;
        });
    }

}
