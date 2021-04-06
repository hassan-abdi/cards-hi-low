package com.ha.hilo;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void testEquals() {
        Card card = new Card(Card.Type.CLUB, 12);
        assertEquals(new Integer(12), card.getOrder());
        assertEquals(Card.Type.CLUB, card.getType());
    }

    @Test
    public void testHigherShouldPass() {
        Card higher = new Card(Card.Type.CLUB, 12);
        Card lower = new Card(Card.Type.CLUB, 5);
        Assert.assertTrue(higher.compareTo(lower) > 0);
    }

    @Test
    public void testLowerShouldPass() {
        Card lower = new Card(Card.Type.DIAMOND, 3);
        Card higher = new Card(Card.Type.DIAMOND, 12);
        Assert.assertTrue(lower.compareTo(higher) < 0);
    }
}