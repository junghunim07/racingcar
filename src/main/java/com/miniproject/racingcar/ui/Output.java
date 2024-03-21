package com.miniproject.racingcar.ui;

public class Output {

    private static final String TAKE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TAKE_GAME_COUNT = "시도할 회수는 몇회인가요?";

    public static void receiveUserName() {
        System.out.println(TAKE_CAR_NAME);
    }

    public static void receiveGameCount() {
        System.out.println(TAKE_GAME_COUNT);
    }
}
