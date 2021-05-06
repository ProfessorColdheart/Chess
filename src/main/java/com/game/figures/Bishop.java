package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.List;

public class Bishop extends Figure {
    public Bishop(int x, int y, Side side) {
        super(FigureType.BISHOP, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoves() {
        return finder.listDiagonalLines();
    }
}
