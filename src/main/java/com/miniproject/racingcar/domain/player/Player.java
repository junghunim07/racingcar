package com.miniproject.racingcar.domain.player;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {

    private String username;
    private int total;
    private int victory;
    private int loss;
    private int point;

    public Player() {
    }

    public Player(String username) {
        this.username = username;
        total = 0;
        victory = 0;
        loss = 0;
        point = 0;
    }
}
