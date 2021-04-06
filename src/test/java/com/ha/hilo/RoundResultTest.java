package com.ha.hilo;


import org.junit.Assert;
import org.junit.Test;

public class RoundResultTest {

    @Test
    public void calculateWinnerShouldPass(){
        RoundResult roundResult = new RoundResult();
        roundResult.count(new Player("Goofy"));
        roundResult.count(new Player("Goofy"));
        roundResult.count(new Player("Goofy"));
        roundResult.count(new Player("Mickey"));
        roundResult.count(new Player("Mickey"));
        Player winner = roundResult.getWinner();
        Assert.assertEquals("Goofy", winner.getName());
    }
}