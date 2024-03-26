package com.miniproject.racingcar.domain;

public class Player {

    private final Car car;
    private int totalMatch;
    private int victoryMatch;
    private int lossMatch;
    private int point;

    public Player(String name) {
        car = makeCar(name);
        totalMatch = 0;
        victoryMatch = 0;
        lossMatch = 0;
        point = 0;
    }

    public int moveCar() {
        return car.movingForward();
    }

    public int stopCar() {
        return car.movingStop();
    }

    public void win() {
        if (checkingMatchCount()) {
            totalMatch++;
            victoryMatch++;
            point += 20;
        }
    }

    public void loss() {
        if (checkingMatchCount()) {
            totalMatch++;
            lossMatch++;
        }
    }

    @Override
    public String toString() {
        return car.getCarName();
    }

    private boolean checkingMatchCount() {
        if (totalMatch == victoryMatch + lossMatch) {
            return true;
        }
        return false;
    }

    private Car makeCar(String name) {
        return new Car(name);
    }
}
