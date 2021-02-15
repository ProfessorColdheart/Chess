package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class Pawn extends Figure {
    public Pawn(int x, int y, Side side) {
        super(FigureType.PAWN, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsOnVerticalLine(i, j)
                && (algorithm.fieldIsTwoFieldsFarFromFigure(i, j)
                || algorithm.fieldIsOneFieldFarFromFigure(i, j))
                && algorithm.fieldIsAheadOfAFigure(i, j, this.getSide());
    }
}
