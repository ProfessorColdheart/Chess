package com.game;

import java.util.Objects;

public class Coord {
   public static final Coord INVALID_COORD = new Coord(-1, -1);

   private final int x;
   private final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
