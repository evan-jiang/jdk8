package com.tdpark.jdk8.time.b.localdate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @Description: 日期测试类
 * @author Evan Jiang
 * @date 2019年3月28日 下午4:39:13 
 *
 */
public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        //当天日期
        System.out.println(localDate);
        //两天后的日期
        System.out.println(localDate.plusDays(2));
        //当月第一天的日期
        System.out.println(localDate.withDayOfMonth(1));
        //当年第一天的日期
        System.out.println(localDate.withDayOfYear(1));
        //当期日期是本周第几天
        System.out.println(localDate.getDayOfWeek().getValue());
        //当期日期是本月第几天
        System.out.println(localDate.getDayOfMonth());
        //当期日期是本年第几天
        System.out.println(localDate.getDayOfYear());
        //构造日期
        localDate = LocalDate.of(2019, 3, 31);
        //当年2月份的今天，当日期大于指定月的天数时去指定月的最后一天
        System.out.println(localDate.withMonth(2));
        //LocalDate转Date
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
        //Date转LocalDate
        //LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        //格式化
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("EEE,yyyy年MM月dd日")));
        //解析
        System.out.println(LocalDate.parse("星期日,2019年03月31日", DateTimeFormatter.ofPattern("EEE,yyyy年MM月dd日")));
    }
}
