package com.tdpark.jdk8.stream;

public class Student {

    private String  name;
    private Integer score;

    public Student(String name, Integer score) {
        super();
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "[姓名=" + name + ", 分数=" + score + "]";
    }

}
