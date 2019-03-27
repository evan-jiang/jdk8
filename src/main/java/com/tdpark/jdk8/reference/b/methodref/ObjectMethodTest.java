package com.tdpark.jdk8.reference.b.methodref;

import java.util.Arrays;
import java.util.List;

/**
 * 类ObjectMethodTest.java的实现描述：对象方法引用
 * 
 * @author jiangyongsheng 2019年3月26日 下午12:04:39
 */
public class ObjectMethodTest {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(new Person("MJ"), new Person("Kobe"), new Person("LBJ"), new Person("TD"),
                new Person("KG"));
        PersonSorter personSorter = new PersonSorter();
        //对象方法引用 正序
        list.sort(personSorter::compareByName);
        list.forEach(System.out::print);
    }

}

/**
 * 类ObjectMethodTest.java的实现描述：排序器
 * 
 * @author jiangyongsheng 2019年3月26日 下午12:15:23
 */
class PersonSorter {

    public int compareByName(Person p1, Person p2) {
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
