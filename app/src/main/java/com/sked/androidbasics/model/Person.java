package com.sked.androidbasics.model;

/**
 * Created by manish on 10/2/2015.
 */
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
    private String number;

    @Override
    public String toString() {
        return name + ":" + age + "\n" + number;
    }
}
