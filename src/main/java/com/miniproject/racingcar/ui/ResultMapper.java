package com.miniproject.racingcar.ui;

import java.util.List;

public class ResultMapper {

    public static void printResultForm(String player, int position) {
        Output.printResultPerCountInGame(player + " : "
                + "-".repeat(Math.max(0, position)));
    }

    public static void printWinnersOrWinnerForm(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winner.size(); i++) {
            sb.append(winner.get(i));
            if (i < winner.size() - 1) {
                sb.append(", ");
            }
        }
        Output.printMatchWinner(sb);
    }
}
