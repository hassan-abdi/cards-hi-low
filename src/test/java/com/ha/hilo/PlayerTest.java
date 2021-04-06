package com.ha.hilo;


import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void shouldBeEqual(){
        Player p1 = new Player("Hassan");
        Player p2 = new Player("Hassan");
        Assert.assertEquals(p1, p2);
    }

    @Test
    public void shouldNotBeEqual(){
        Player p1 = new Player("Hassan");
        Player p2 = new Player("Abdi");
        Assert.assertNotEquals(p1, p2);
    }

}