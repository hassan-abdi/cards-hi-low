package com.ha.hilo;


import org.junit.Assert;
import org.junit.Test;

public class EventTest {

    @Test
    public void shouldEquals(){
        Event event = new Event(Event.Type.GAME_START);
        Assert.assertEquals(event.getType(), Event.Type.GAME_START);
    }
}