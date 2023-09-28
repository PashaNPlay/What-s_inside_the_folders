package com.javarush.task.task31.task3113;

public class MyMutableInteger {
    private Integer value;

    public MyMutableInteger(Integer value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public Integer getValue() {
        return value;
    }
}
