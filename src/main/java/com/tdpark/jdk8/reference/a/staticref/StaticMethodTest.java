package com.tdpark.jdk8.reference.a.staticref;

import java.util.Arrays;
import java.util.List;

/**
 * 类StaticMethodTest.java的实现描述：静态方法引用测试类
 * 
 * @author jiangyongsheng 2019年3月26日 上午11:59:37
 */
public class StaticMethodTest {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("MJ"), new Person("Kobe"), new Person("LBJ"), new Person("TD"),
                new Person("KG"));
        //静态方法引用 正序
        list.sort(PersonSorter::compareByName);
        list.forEach(System.out::print);
    }
}

/**
 * 类ObjectMethodTest.java的实现描述：静态排序器
 * 
 * @author jiangyongsheng 2019年3月26日 下午12:15:23
 */
class PersonSorter {

    public static int compareByName(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class Person {
    private String name;

    public Person(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ",";
    }

}
