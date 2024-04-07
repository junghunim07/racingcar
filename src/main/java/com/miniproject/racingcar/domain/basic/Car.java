package com.miniproject.racingcar.domain.basic;

public class Car {

    private final String carName;
    private final int MOVE = 1;
    private final int STOP = 0;

    public Car(String name) {
        carName = name;
    }

    public int movingForward() {
        return MOVE;
    }

    public int movingStop() {
        return STOP;
    }

    public String getCarName() {
        return carName;
    }
}
