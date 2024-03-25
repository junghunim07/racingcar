package com.miniproject.racingcar.ui;

import com.miniproject.racingcar.exception.InputException;

import java.util.Scanner;

public class Input {

    private static Scanner getSC() {
        return new Scanner(System.in);
    }

    public static String[] inputUserName() {
        String input = getSC().nextLine();
        String[] users = input.split(",");

        for (String user : users) {
            checkingCountValidation(user);
        }

        return users;
    }

    private static void checkingCountValidation(String user) {
        if (user.length() > 5) {
            InputException.wrongInput();
        }
    }

    public static int inputGameCount() {
        String input = getSC().nextLine();
        if (!checkingCount(input)) {
            InputException.wrongInput();
        }

        return Integer.parseInt(input);
    }

    private static boolean checkingCount(String cnt) {
        try {
            Integer.parseInt(cnt);
            return true;
        } catch (NumberFormatException e) {
            InputException.wrongInput();
        }
        return false;
    }
}
