package com.javacountries.demo;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long pop;
    private long mass;
    private int age;

    public Country(String name, long pop, long mass, int age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.pop = pop;
        this.mass = mass;
        this.age = age;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public long getPop() {
        return pop;
    }

    public long getMass() {
        return mass;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Country{" + "id: " + id + ", name: " + name + ", pop: " + pop + ", mass: " + mass + ", age: " + age + "}";
    }
}
