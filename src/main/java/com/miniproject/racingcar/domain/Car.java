package com.miniproject.racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public void forward() {
        position++;
    }

    public void back() {
        position--;
    }
}