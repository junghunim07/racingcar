package com.miniproject.racingcar.ui;

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
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값");
        }
    }

    public static int inputGameCount() {
        String input = getSC().nextLine();
        if (!checkingCount(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값");
        }

        return Integer.parseInt(input);
    }

    private static boolean checkingCount(String cnt) {
        try {
            Integer.parseInt(cnt);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값");
        }
    }
}
