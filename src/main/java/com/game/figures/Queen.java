package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure {
    public Queen(int x, int y, Side side) {
        super(FigureType.QUEEN, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoves() {
        List<Coord> resultList = new ArrayList<>();
        resultList.addAll(finder.listDiagonalLines());
        resultList.addAll(finder.listVerticalAndHorizontalLines());

        return resultList;
    }
}
