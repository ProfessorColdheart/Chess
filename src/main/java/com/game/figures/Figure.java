package com.game.figures;

import com.game.Coord;
import com.game.Move;
import com.game.Side;

import java.util.*;
import java.util.stream.Collectors;


public abstract class Figure {
    protected FigureType name;
    protected int x, y;
    protected Side side;
    protected MovesFinder finder;
    boolean firstMove = true;

    public Figure(FigureType name, int x, int y, Side side) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public  List<Move> getPossibleMoves(){
        return getPossibleMoveCoords().stream()
                .map(coord -> new Move(new Coord(x, y), coord, finder.isAttack(coord)))
                //.filter() // odrzuć ruch jeśli spowoduje szacha
                .collect(Collectors.toList());
    }
    protected abstract List<Coord> getPossibleMoveCoords();



    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        firstMove = false;
    }

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

    public Coord getCoord() {
        return new Coord(x, y);
    }

    public FigureType getName() {
        return name;
    }

    public Side getSide() {
        return side;
    }

    public void setMovesFinder(MovesFinder finder) {
        this.finder = finder;
    }

    public boolean isFirstMove() {
        return firstMove;
    }
}
