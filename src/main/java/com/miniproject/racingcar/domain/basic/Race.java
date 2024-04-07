package com.miniproject.racingcar.domain.basic;

import com.miniproject.racingcar.service.basic.RaceService;
import com.miniproject.racingcar.ui.ResultMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Race {

    private static HashMap<Player, Integer> raceMap;
    private final int count;
    private final RaceService raceService;
    private int maxDistance;
    private List<String> matchWinner;

    public Race(String[] names, int count) {
        raceMap = new HashMap<>();
        raceService = new RaceService();
        matchWinner = new ArrayList<>();
        maxDistance = 0;
        this.count = count;
        makePlayer(names);
    }

    public void match() {
        for (int i = 0; i < count; i++) {
            matchPerCount();
        }
        matchWinner();
    }

    private void matchWinner() {
        calculateMaxDistanceInMatch();
        recordMatchResultInPlayer();
        ResultMapper.printWinnersOrWinnerForm(matchWinner);
    }

    private void calculateMaxDistanceInMatch() {
        for (Player player : raceMap.keySet()) {
            if (maxDistance < raceMap.get(player)) {
                maxDistance = raceMap.get(player);
            }
        }
    }

    private void recordMatchResultInPlayer() {
        for (Player player : raceMap.keySet()) {
            winOrLossPlayer(player);
        }
    }

    private void winOrLossPlayer(Player player) {
        if (raceMap.get(player) == maxDistance) {
            containWinnerList(player);
            player.win();
        }

        if (raceMap.get(player) != maxDistance) {
            player.loss();
        }
    }

    private void containWinnerList(Player player) {
        matchWinner.add(player.toString());
    }

    private void matchPerCount() {
        for (Player player : raceMap.keySet()) {
            matchWinnerPerCount(player);
            ResultMapper.printResultForm(player.toString(), raceMap.get(player));
        }
    }

    private void matchWinnerPerCount(Player player) {
        if (raceService.game()) {
            playerWin(player);
        }

        if (!raceService.game()) {
            computerWin(player);
        }
    }

    private void playerWin(Player player) {
        raceMap.put(player, raceMap.get(player) + player.moveCar());
    }

    private void computerWin(Player player) {
        raceMap.put(player, raceMap.get(player) + player.stopCar());
    }

    private void makePlayer(String[] names) {
        for (String name : names) {
            raceMap.put(new Player(name), 0);
        }
    }
}
