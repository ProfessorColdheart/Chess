package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.List;

public class Rook extends Figure {
    public Rook(int x, int y, Side side) {
        super(FigureType.ROOK, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoves() {
        return finder.listVerticalAndHorizontalLines();
    }
}
