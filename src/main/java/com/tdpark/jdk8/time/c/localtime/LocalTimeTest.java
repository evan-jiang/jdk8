package com.tdpark.jdk8.time.c.localtime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @Description: 时间测试类
 * @author Evan Jiang
 * @date 2019年3月28日 下午4:39:38 
 *
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //小时
        System.out.println(localTime.getHour());
        //分钟
        System.out.println(localTime.getMinute());
        //秒钟
        System.out.println(localTime.getSecond());
        //纳秒
        System.out.println(localTime.getNano());
        //一个小时前的时间
        System.out.println(localTime.minusHours(1));
        //一个小时后的时间
        System.out.println(localTime.plusHours(1));
        //格式化
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH-mm-ss")));
        //构造时间
        localTime = LocalTime.of(11, 11, 11);
        System.out.println(localTime);
        //解析时间
        localTime = LocalTime.parse("11-11-11", DateTimeFormatter.ofPattern("HH-mm-ss"));
        System.out.println(localTime);
        //Date转LocalTime
        //LocalDateTime.ofInstant(new Date().toInstant(),ZoneId.systemDefault()).toLocalTime();
    }
}
