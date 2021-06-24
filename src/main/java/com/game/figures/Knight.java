package com.game.figures;

import com.game.Coord;
import com.game.Side;

import java.util.List;

public class Knight extends Figure {
    public Knight(int x, int y, Side side) {
        super(FigureType.KNIGHT, x, y, side);
    }

    @Override
    public List<Coord> getPossibleMoveCoords() {
        return finder.listLShapeMovements();
    }
}
