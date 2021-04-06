package com.ha.hilo;

public class Card implements Comparable<Card> {

    public enum Type {CLUB, DIAMOND, HEART, SPADE}
    private final Type type;
    private final Integer order;

    public Card(Type type, Integer order) {
        this.type = type;
        this.order = order;
    }

    public Type getType() {
        return type;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public int compareTo(Card o) {
        int result = this.getType().compareTo(o.getType());
        if (result != 0)
            return result;
        return this.getOrder().compareTo(o.getOrder());
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", order=" + order +
                '}';
    }
}
