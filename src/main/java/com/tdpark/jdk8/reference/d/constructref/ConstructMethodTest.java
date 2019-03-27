package com.tdpark.jdk8.reference.d.constructref;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * 类ObjectMethodTest.java的实现描述：对象方法引用
 * 
 * @author jiangyongsheng 2019年3月26日 下午12:04:39
 */
public class ConstructMethodTest {

    public static void main(String[] args) {
        //引用构造方法
        PersonFactory<Person> factory = new PersonFactory<Person>(Person::new);
        List<Person> list = Arrays.asList(factory.newInstance(), factory.newInstance(), factory.newInstance(),
                factory.newInstance(), factory.newInstance());
        list.forEach(System.out::print);
    }

}

/**
 * 类ConstructMethodTest.java的实现描述：工厂类
 * 
 * @author jiangyongsheng 2019年3月26日 下午2:24:01
 */
class PersonFactory<T> {
    private java.util.function.Supplier<T> supplier;

    public PersonFactory(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T newInstance() {
        //每次调用都会执行T的默认构造方法生成新的对象
        return this.supplier.get();
    }
}

class Person {
    private String name;

    public Person() {
        this(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
    }

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
