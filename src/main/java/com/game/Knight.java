package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class Knight extends Figure {
    public Knight(int x, int y, Side side) {
        super(FigureType.KNIGHT, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsTwoFieldsFarFromFigure(i, j)
                && !algorithm.fieldIsOnDiagonalLines(i, j)
                && !algorithm.fieldIsOnVerticalLine(i, j)
                && !algorithm.fieldIsOnHorizontalLine(i, j);
    }
}
