package com.game;

import java.util.Objects;


public abstract class Figure {
    protected FigureType name;
    protected int x, y;
    protected Side side;

    public Figure(FigureType name, int x, int y, Side side) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.side = side;
    }

//    public abstract List<Move> getPossibleMoves();

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", side=" + side +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return x == figure.x && y == figure.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public FigureType getName() {
        return name;
    }

    public Side getSide() {
        return side;
    }
}
