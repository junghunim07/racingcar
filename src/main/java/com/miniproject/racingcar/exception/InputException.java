package com.miniproject.racingcar.exception;

public class InputException {

    public static void wrongInput() throws IllegalArgumentException{
        throw new IllegalArgumentException("[ERROR] 잘못된 입력값을 입력했습니다.");
    }
}
