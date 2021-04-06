package com.ha.hilo;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Game {
    private final Integer rounds;
    private final List<Player> players;
    private final Deck deck;
    private final RoundResult roundResult;
    private final Observer observer;

    public Game(Integer rounds, List<Player> players, Observer observer) {
        this.rounds = rounds;
        this.players = players;
        this.observer = observer;
        this.deck = new Deck();
        this.roundResult = new RoundResult();
    }

    public void play() {
        observer.update(new Event(Event.Type.GAME_START));
        IntStream.rangeClosed(1, rounds)
                .boxed()
                .forEach(this::playRound);
        Player winner = roundResult.getWinner();
        observer.update(new Event.GameWinEvent(winner));
        observer.update(new Event(Event.Type.GAME_END));
    }

    private void playRound(Integer round) {
        observer.update(new Event(Event.Type.ROUND_START));
        Map<Player, Card> cards = obtainCardsForRound();
        List<Player> highestPlayers = findHighestPlayers(cards);
        if (highestPlayers.size() > 1){
            observer.update(new Event(Event.Type.ROUND_DRAW));
            return;
        }
        Player winner = highestPlayers.stream().findFirst().orElseThrow(RuntimeException::new);
        roundResult.count(winner);
        observer.update(new Event(Event.Type.ROUND_WIN));
        observer.update(new Event(Event.Type.ROUND_END));
    }

    private List<Player> findHighestPlayers(Map<Player, Card> cards) {
        Card highestCard = findHighestCard(cards);
        return cards.entrySet().stream()
                .filter(o -> o.getValue().getOrder().equals(highestCard.getOrder()))
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    private Card findHighestCard(Map<Player, Card> cards) {
        return Collections.max(cards.values());
    }

    private Map<Player, Card> obtainCardsForRound() {
        final Map<Player, Card> result = new HashMap<>();
        players.forEach(player -> result.put(player, deck.obtainCard()));
        return result;
    }

    public static class TwoPlayerGameBuilder {
        public static Game build(int round) {
            return new Game(round, Arrays.asList(
                    new Player("Goofy"),
                    new Player("Mickey")),
                    e -> System.out.println("e = " + e));
        }
    }
}
