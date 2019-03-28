package com.tdpark.jdk8.time.a.zone;

import java.time.ZoneId;
import java.util.Set;

import com.tdpark.jdk8.PrintUtils;

/**
 * 
 * @Description: 时区测试类
 * @author Evan Jiang
 * @date 2019年3月28日 下午4:17:24 
 *
 */
public class ZoneIdTest {

    public static void main(String[] args) {
        //系统支持的时区
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);
        PrintUtils.split();
        //当地时区
        System.out.println(ZoneId.systemDefault());
    }
}
