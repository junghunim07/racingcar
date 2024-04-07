package com.miniproject.racingcar.domain;

import lombok.Getter;

@Getter
public class Player {

    private String name;
    private int total;
    private int victory;
    private int defeat;
    private int point;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int total, int victory, int defeat, int point) {
        this.name = name;
        this.total = total;
        this.victory = victory;
        this.defeat = defeat;
        this.point = point;
    }

    public void win() {
        total += 1;
        victory += 1;
        point += 20;
    }

    public void lose() {
        total += 1;
        defeat += 1;
    }
}
