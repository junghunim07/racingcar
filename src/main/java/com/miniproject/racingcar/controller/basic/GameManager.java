package com.miniproject.racingcar.controller.basic;

import com.miniproject.racingcar.domain.basic.Race;
import com.miniproject.racingcar.ui.Input;
import com.miniproject.racingcar.ui.Output;

public class GameManager {

    public static void start() {
        Race race = new Race(userList(), gameCount());
        race.match();
    }

    private static int gameCount() {
        Output.receiveGameCount();
        return Input.inputGameCount();
    }

    private static String[] userList() {
        Output.receiveUserName();
        return Input.inputUserName();
    }
}
