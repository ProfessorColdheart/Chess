package com.game.algorithm.findingpossiblemoves;

import com.game.Figure;
import com.game.Move;
import com.game.Side;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

public class FindingPossibleMoves {
    final private int figurePositionX;
    final private int figurePositionY;

    public FindingPossibleMoves(int figurePositionX, int figurePositionY) {
        this.figurePositionX = figurePositionX;
        this.figurePositionY = figurePositionY;
    }


    public Set<Move> find(Figure figure) {
        Set<Move> selectedMoves = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (figure.ruleOfMovement(i, j)) {
                    selectedMoves.add(new Move(i, j));
                }
            }
        }

        return selectedMoves;
    }

    public boolean fieldIsOnLeftDiagonalLine(int i, int j) {
        return figurePositionX - figurePositionY == i - j;
    }

    public boolean fieldIsOnRightDiagonalLine(int i, int j) {
        return figurePositionX + figurePositionY == i + j;
    }

    public boolean fieldIsOnDiagonalLines(int i, int j) {
        return fieldIsOnLeftDiagonalLine(i, j) || fieldIsOnRightDiagonalLine(i, j);
    }

    public boolean fieldIsOnVerticalLine(int i, int j) {
        return figurePositionX == i;
    }

    public boolean fieldIsOnHorizontalLine(int i, int j) {
        return figurePositionY == j;
    }

    public boolean fieldIsAheadOfAFigure(int i, int j, Side side) {
        if (side == Side.WHITE) {
            return j < figurePositionY;
        } else {
            return j > figurePositionY;
        }
    }

    public boolean fieldIsOneFieldFarFromFigure(int i, int j) {
        int greaterX = Math.max(figurePositionX, i);
        int lowerX = Math.min(figurePositionX, i);
        int greaterY = Math.max(figurePositionY, j);
        int lowerY = Math.min(figurePositionY, j);

        return (greaterX - lowerX == 1 && greaterY - lowerY <= 1)
                || (greaterX - lowerX <= 1 && greaterY - lowerY == 1);
    }

    public boolean fieldIsTwoFieldsFarFromFigure(int i, int j) {

        int greaterX = Math.max(figurePositionX, i);
        int lowerX = Math.min(figurePositionX, i);
        int greaterY = Math.max(figurePositionY, j);
        int lowerY = Math.min(figurePositionY, j);

        return (greaterX - lowerX == 2 && greaterY - lowerY <= 2)
                || (greaterX - lowerX <= 2 && greaterY - lowerY == 2);
    }
}
