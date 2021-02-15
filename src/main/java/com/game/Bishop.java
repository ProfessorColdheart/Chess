package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class Bishop extends Figure {
    public Bishop(int x, int y, Side side) {
        super(FigureType.BISHOP, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsOnDiagonalLines(i, j);
    }
}
