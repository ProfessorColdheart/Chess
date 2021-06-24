package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {
    public King(int x, int y, Side side) {
        super(FigureType.KING, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoveCoords() {
        List<Coord> resultList = new ArrayList<>();
        resultList.addAll(finder.listDiagonalLines());
        resultList.addAll(finder.listVerticalAndHorizontalLines());
        resultList.removeIf(coord -> !finder.fieldIsOneFieldFarFromFigure(coord.getX(), coord.getY()));
        return resultList;
    }
}
