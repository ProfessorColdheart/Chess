package com.game;

import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;

public class King extends Figure {
    public King(int x, int y, Side side) {
        super(FigureType.KING, x, y, side);
    }

    @Override
    public boolean ruleOfMovement(int i, int j) {
        FindingPossibleMoves algorithm = new FindingPossibleMoves(x, y);

        return algorithm.fieldIsOneFieldFarFromFigure(i, j);
    }
}
