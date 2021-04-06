package com.ha;

import com.ha.hilo.Game;

public class Application {
    public static void main(String[] args) {
        Game.TwoPlayerGameBuilder.build(5).play();
    }
}
