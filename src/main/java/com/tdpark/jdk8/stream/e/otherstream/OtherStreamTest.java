package com.tdpark.jdk8.stream.e.otherstream;

import java.util.Random;
import java.util.stream.IntStream;

import com.tdpark.jdk8.PrintUtils;
/**
 * 
 * @Description: 其他类型流测试类
 * @author Evan Jiang
 * @date 2019年3月28日 上午11:12:50 
 *
 */
public class OtherStreamTest {

    public static void main(String[] args) {
        //左闭右开
        IntStream.range(1, 10).forEach(j -> {
            //左闭右闭
            IntStream.rangeClosed(1, j).forEach(i -> {
                System.out.printf("%s * %s =%2s, ", i, j, j * i);
            });
            System.out.println();
        });
        PrintUtils.split();
        Random random = new Random();
        //如果没有limit就是个无限流
        IntStream.generate(random::nextInt).limit(5).forEach(System.out::println);
    }
}
