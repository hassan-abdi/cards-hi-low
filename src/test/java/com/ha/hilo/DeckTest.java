package com.ha.hilo;

import org.junit.Test;

public class DeckTest {

    @Test
    public void createDeckShouldPass(){
        Deck deck = new Deck();
        int numberOfAllCards = 13 * Card.Type.values().length;
        for(int i = 0; i < numberOfAllCards; i++){
            Card card = deck.obtainCard();
            System.out.println("card = " + card);
        }
    }

    @Test(expected = RuntimeException.class)
    public void createDeckWithExtraObtainsShouldGetException(){
        Deck deck = new Deck();
        int numberOfAllCards = 100;
        for(int i = 0; i < numberOfAllCards; i++){
            Card card = deck.obtainCard();
            System.out.println("card = " + card);
        }
    }
}