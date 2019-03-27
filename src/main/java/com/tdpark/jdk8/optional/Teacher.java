package com.tdpark.jdk8.optional;

import java.util.Optional;

public class Teacher {
    private String  name;
    private Integer age;

    public Teacher() {
        this("X", 0);
    }

    public Teacher(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + name + ":" + age + "]";
    }

    public static Optional<String> name(Teacher teacher) {
        return Optional.ofNullable(teacher).map(Teacher::getName);
    }
}
