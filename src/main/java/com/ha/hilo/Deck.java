package com.ha.hilo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    public static final int CARD_COUNT = 13;
    private final List<Card> cards;

    public Deck() {
        cards = new CardsBuilder().build();
        shuffle(cards);
    }

    public Card obtainCard() {
        if (cards.isEmpty())
            throw new RuntimeException();
        return cards.remove(0);
    }

    private void shuffle(List<Card> list) {
        Collections.shuffle(list);
    }

    public static class CardsBuilder {
        public List<Card> build() {
            List<Card> cards = new ArrayList<>();
            for (Card.Type type : Card.Type.values())
                cards.addAll(buildByType(type));
            return cards;
        }

        private List<Card> buildByType(Card.Type type) {
            return IntStream.range(0, CARD_COUNT)
                    .boxed()
                    .map(index -> new Card(type, index))
                    .collect(Collectors.toList());
        }
    }
}