package com.game;

import com.game.figures.*;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {

    private GameState gameState;

    public FigureFactory(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Figure> buildAllFigures() {
        List<Figure> allFigures = new ArrayList<>();
        for (FigureType figureType : FigureType.values()) {
            allFigures.addAll(createAllFiguresOfThatType(Side.WHITE,figureType));
           allFigures.addAll(createAllFiguresOfThatType(Side.BLACK,figureType));
        }
        return allFigures;
    }

    public List<Figure> createAllFiguresOfThatType(Side side, FigureType type) {
        List<Figure> figures = new ArrayList<>();
        List<Coord> startingPositions = getStartPositionList(side,type);
        for (Coord coord : startingPositions) {
            Figure figure = createOneFigure(side, type, coord);
            MovesFinder finder = new MovesFinder(figure, gameState);
            figures.add(figure);
            figure.setMovesFinder(finder);
        }
        return figures;
    }

    private List<Coord> getStartPositionList(Side side, FigureType type) {
        List<Coord> startPositionList = new ArrayList<>();
        int y;

        switch (type) {
            case PAWN:
                y = side == Side.WHITE ? 6 : 1;
                for (int i = 0; i < 8; i++) {
                    startPositionList.add(new Coord(i, y));
                }
                break;
            case KING:
                y = side == Side.WHITE ? 7 : 0;
                startPositionList.add(new Coord(4, y));
                break;
            case ROOK:
                y = side == Side.WHITE ? 7 : 0;
                startPositionList.add(new Coord(0, y));
                startPositionList.add(new Coord(7, y));
                break;
            case BISHOP:
                y = side == Side.WHITE ? 7 : 0;
                startPositionList.add(new Coord(2, y));
                startPositionList.add(new Coord(5, y));
                break;
            case QUEEN:
                y = side == Side.WHITE ? 7 : 0;
                startPositionList.add(new Coord(3, y));
                break;
            case KNIGHT:
                y = side == Side.WHITE ? 7 : 0;
                startPositionList.add(new Coord(1, y));
                startPositionList.add(new Coord(6, y));
                break;
            default:
        }
        return startPositionList;
    }

    private Figure createOneFigure(Side side, FigureType type, Coord coord){
        Figure figure;
        switch (type) {
            case PAWN:
                figure = new Pawn(coord.getX(), coord.getY(), side);
                break;
            case KING:
                figure = new King(coord.getX(), coord.getY(), side);
                break;
            case ROOK:
                figure = new Rook(coord.getX(), coord.getY(), side);
                break;
            case BISHOP:
                figure = new Bishop(coord.getX(), coord.getY(), side);
                break;
            case QUEEN:
                figure = new Queen(coord.getX(), coord.getY(), side);
                break;
            case KNIGHT:
                figure = new Knight(coord.getX(), coord.getY(), side);
                break;
            default:
                throw new IllegalStateException("Figure type not correct");
        }
        return figure;
    }


}
