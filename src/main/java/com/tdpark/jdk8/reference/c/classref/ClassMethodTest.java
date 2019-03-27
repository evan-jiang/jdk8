package com.tdpark.jdk8.reference.c.classref;

import java.util.Arrays;
import java.util.List;

/**
 * 类ObjectMethodTest.java的实现描述：对象方法引用
 * 
 * @author jiangyongsheng 2019年3月26日 下午12:04:39
 */
public class ClassMethodTest {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(new Person("MJ"), new Person("Kobe"), new Person("LBJ"), new Person("TD"),
                new Person("KG"));
        //类型对象方法引用 正序
        list.sort(Person::compareByName);
        list.forEach(System.out::print);
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

    public int compareByName(Person p) {
        return this.getName().compareTo(p.getName());
    }
}
