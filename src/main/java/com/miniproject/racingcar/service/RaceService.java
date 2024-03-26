package com.miniproject.racingcar.service;

import com.miniproject.racingcar.domain.RandomNumberMaker;

public class RaceService {

    public boolean game() {
        if (RandomNumberMaker.makeRandomNum() >= 4) {
            return true;
        }
        return false;
    }
}
