package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {
    public Pawn(int x, int y, Side side) {
        super(FigureType.PAWN, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoveCoords() {
        List<Coord> resultList = new ArrayList<>(finder.listPawnMoves());

        return resultList;
    }
}
