package com.miniproject.racingcar.service.basic;

import com.miniproject.racingcar.domain.basic.RandomNumberMaker;

public class RaceService {

    public boolean game() {
        if (RandomNumberMaker.makeRandomNum() >= 4) {
            return true;
        }
        return false;
    }
}
