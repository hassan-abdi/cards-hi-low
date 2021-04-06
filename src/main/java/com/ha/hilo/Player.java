package com.ha.hilo;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + getName() + '\'' +
                '}';
    }
}