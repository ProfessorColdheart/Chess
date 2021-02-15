package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class Rook extends Figure{
    public Rook(int x, int y, Side side) {
        super(FigureType.ROOK, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsOnVerticalLine(i, j)
                || algorithm.fieldIsOnHorizontalLine(i, j);
    }
}
