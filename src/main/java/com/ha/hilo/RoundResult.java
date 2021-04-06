package com.ha.hilo;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;

public class RoundResult {
    private final Map<Player, Integer> result = new HashMap<>();

    public void count(Player winner) {
        result.putIfAbsent(winner, 0);
        result.put(winner, result.get(winner) + 1);
    }

    public Player getWinner(){
        Integer numberOfWins = result.entrySet().stream()
                .max(comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);
        return result.entrySet()
                .stream()
                .filter(o -> o.getValue().equals(numberOfWins))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(RuntimeException::new);
    }
}
