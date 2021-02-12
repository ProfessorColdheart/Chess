package com.game;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    public List<Figure> buildAllFigures() {
        List<Figure> allFigures = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Pawn pawnB = new Pawn(i, 1, Side.BLACK);
            Pawn pawnW = new Pawn(i, 6, Side.WHITE);
            allFigures.addAll(List.of(pawnB, pawnW));
        }

        for (int i = 0; i < 8; i += 7) {
            Rook rookB = new Rook(i, 0, Side.BLACK);
            Rook rookW = new Rook(i, 7, Side.WHITE);
            allFigures.addAll(List.of(rookB, rookW));

        }

        for (int i = 1; i < 8; i += 5) {
            Knight knightB = new Knight(i, 0, Side.BLACK);
            Knight knightW = new Knight(i, 7, Side.WHITE);
            allFigures.addAll(List.of(knightW, knightB));

        }

        for (int i = 2; i < 8; i += 3) {
            Bishop bishopB = new Bishop(i, 0, Side.BLACK);
            Bishop bishopW = new Bishop(i, 7, Side.WHITE);
            allFigures.addAll(List.of(bishopB, bishopW));
        }

        Queen queenB = new Queen(3, 0, Side.BLACK);
        Queen queenW = new Queen(3, 7, Side.WHITE);
        King kingB = new King(4, 0, Side.BLACK);
        King kingW = new King(4, 7, Side.WHITE);
        allFigures.addAll(List.of(kingW, kingB, queenB, queenW));


        return allFigures;
    }
}
