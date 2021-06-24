package com.game;

public class Move {
    private final Coord from;
    private final Coord to;
    private final boolean attack;

    public Move(Coord from, Coord to, boolean attack) {
        this.from = from;
        this.to = to;
        this.attack = attack;
    }

    public Coord getFrom() {
        return from;
    }

    public Coord getTo() {
        return to;
    }

    public boolean isAttack() {
        return attack;
    }
}
