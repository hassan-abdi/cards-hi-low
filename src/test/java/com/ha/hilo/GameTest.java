package com.ha.hilo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameTest {

    @Test
    public void shouldPlayWithTwoPlayerShouldPass(){
        List<Event> actualEvents = new ArrayList<>();
        new Game(10, Arrays.asList(
                new Player("Goofy"),
                new Player("Mickey")),
                actualEvents::add)
                .play();
        Long actualNumberOfRoundStartEvents = actualEvents.stream()
                .filter(event -> event.getType().equals(Event.Type.ROUND_START))
                .count();

        List<Event> listOfWinsEvent = actualEvents.stream()
                .filter(event -> event.getType().equals(Event.Type.GAME_WIN))
                .collect(Collectors.toList());

        Assert.assertEquals(new Long(10L), actualNumberOfRoundStartEvents);
        Assert.assertEquals(1, listOfWinsEvent.size());
        Player winner = ((Event.GameWinEvent) listOfWinsEvent.get(0)).getWinner();
        Assert.assertTrue(winner.getName().equals("Goofy") || winner.getName().equals("Mickey"));
    }

}