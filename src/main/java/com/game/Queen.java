package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class Queen extends Figure {
    public Queen(int x, int y, Side side) {
        super(FigureType.QUEEN, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsOnDiagonalLines(i, j)
                || algorithm.fieldIsOnVerticalLine(i, j)
                || algorithm.fieldIsOnHorizontalLine(i, j);
    }
}
