package com.ha.hilo;

public class Event {
    public enum Type {GAME_START, GAME_END, GAME_WIN, ROUND_START, ROUND_END, ROUND_WIN, ROUND_DRAW}
    private final Type type;

    public Event(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                '}';
    }

    public static class GameWinEvent extends Event {
        private final Player winner;
        public GameWinEvent(Player winner) {
            super(Type.GAME_WIN);
            this.winner = winner;
        }

        public Player getWinner() {
            return winner;
        }

        @Override
        public String toString() {
            return "GameWinEvent{" +
                    "type=" + getType() +
                    ", winner=" + getWinner() +
                    '}';
        }
    }
}
