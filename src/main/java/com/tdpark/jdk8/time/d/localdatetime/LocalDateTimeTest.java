package com.tdpark.jdk8.time.d.localdatetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @Description: 日期时间测试类
 * @author Evan Jiang
 * @date 2019年3月28日 下午4:57:22 
 *
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //获取zoneOffset
        ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
        //转换成Date
        Date date = Date.from(localDateTime.toInstant(zoneOffset));
        System.out.println(date);
        //获取毫秒数
        long milli = localDateTime.toInstant(zoneOffset).toEpochMilli();
        System.out.println(milli);
        //Date转LocalDateTime
        localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);
        //格式化
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日HH点mm分ss秒")));
        //解析
        System.out.println(LocalDateTime.parse("2019年03月28日20点53分57秒", DateTimeFormatter.ofPattern("yyyy年MM月dd日HH点mm分ss秒")));
    }
}
