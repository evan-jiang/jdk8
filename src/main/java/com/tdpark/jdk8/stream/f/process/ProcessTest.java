package com.tdpark.jdk8.stream.f.process;

import java.util.Arrays;
import java.util.List;

import com.tdpark.jdk8.PrintUtils;

/**
 * 
 * @Description: 执行顺序测试类
 * @author Evan Jiang
 * @date 2019年3月28日 上午11:27:11
 *
 */
public class ProcessTest {

    public static void main(String[] args) {
        int temp = 6;
        List<Integer> list = Arrays.asList(5, 2, 7, 6, 9);
        list.stream().forEach(System.out::print);
        PrintUtils.split();
        // 过滤执行顺序
        list.stream().filter(i -> {
            System.out.println("Filter:" + i);
            return i >= temp;
        }).forEach(i -> {
            System.out.println("ForEach:" + i);
        });
        PrintUtils.split();
        // 映射执行顺序
        list.stream().map(i -> {
            System.out.println("Map:" + i);
            return ++i;
        }).forEach(i -> {
            System.out.println("ForEach:" + i);
        });
        PrintUtils.split();
        // 排序执行顺序-阻断式:排序前必须循环行完，排序完成后才能执行后面的操作
        list.stream().sorted((i, j) -> {
            System.out.println("Sort:{" + i + "," + j + "}");
            return Integer.compare(i, j);
        }).forEach(i -> {
            System.out.println("ForEach:" + i);
        });
        PrintUtils.split();
        // 排序执行顺序-阻断式:排序前必须循环行完，排序完成后才能执行后面的操作
        list.stream().filter(i -> {
            System.out.println("Filter:" + i);
            return i >= temp;
        }).sorted((i, j) -> {
            System.out.println("Sort:{" + i + "," + j + "}");
            return Integer.compare(i, j);
        }).forEach(i -> {
            System.out.println("ForEach:" + i);
        });
        // 如果排序的是一个无限流就会无限等待
        // IntStream.generate(new
        // Random()::nextInt).sorted().forEach(System.out::println);
        PrintUtils.split();
        // AnyMatch只要存在满足的就停止循环,停止循环后返回true
        System.out.println(list.stream().anyMatch(i -> {
            System.out.println("AnyMatch:" + i);
            return i >= temp;
        }));
        PrintUtils.split();
        // allMatch只要存在不满足的就停止循环,停止循环后返回false
        System.out.println(list.stream().allMatch(i -> {
            System.out.println("allMatch:" + i);
            return i >= temp;
        }));
        PrintUtils.split();
        // noneMatch只要存在满足的就停止循环,停止循环后返回false
        System.out.println(list.stream().noneMatch(i -> {
            System.out.println("noneMatch:" + i);
            return i >= temp;
        }));
    }
}
