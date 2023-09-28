package com.javarush.task.task31.task3113;

public class MyMutableLong {
    private long value;

    public MyMutableLong(long value) {
        this.value = value;
    }

    public void add(long l) {
        value += l;
    }

    public long getValue() {
        return value;
    }
}
