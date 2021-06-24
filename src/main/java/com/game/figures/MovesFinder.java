package com.game.figures;

import com.game.Coord;
import com.game.GameState;
import com.game.Side;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovesFinder {
    private final Figure figure;
    private final GameState gameState;

    public MovesFinder(Figure figure, GameState gameState) {
        this.figure = figure;
        this.gameState = gameState;
    }

    //zaimplementować roszady

/*    public Collection<Coord> nearestOccupiedFieldsInEveryDirection(Collection<Coord> theoreticallyMoves) {
        for (Coord theoreticallyMove : theoreticallyMoves) {
            Figure checkedFigure = gameState.getFigureOn(theoreticallyMove.getX(), theoreticallyMove.getY());

            if (checkedFigure != null) {

            }
        }
    }*/

    public int getX() {
        return figure.getX();
    }

    public int getY() {
        return figure.getY();
    }

    private boolean fieldIsWithinRangeOfTheBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public List<Coord> listNorthVerticalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x, y - 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x, y - 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x, y - 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(x, --y));
        }

        return results;
    }

    public boolean isAttack(Coord to) {
        return gameState.getFigureOn(to.getX(), to.getY()) != null;
    }

    public List<Coord> listSouthVerticalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x, y + 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x, y + 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x, y + 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(x, ++y));
        }

        return results;
    }

    public List<Coord> listWestHorizontalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x - 1, y)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x - 1, y) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x - 1, y).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(--x, y));
        }

        return results;
    }

    public List<Coord> listEastHorizontalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x + 1, y)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x + 1, y) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x + 1, y).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(++x, y));
        }

        return results;
    }


    public List<Coord> listNWDiagonalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x - 1, y - 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x - 1, y - 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x - 1, y - 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(--x, --y));
        }

        return results;
    }

    public List<Coord> listNEDiagonalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x + 1, y - 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x + 1, y - 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x + 1, y - 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(++x, --y));
        }

        return results;
    }

    public List<Coord> listSWDiagonalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x - 1, y + 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x - 1, y + 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x - 1, y + 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(--x, ++y));
        }

        return results;
    }

    public List<Coord> listSEDiagonalLine() {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        boolean lastCheckedFieldIsOccupied = false;

        while (fieldIsWithinRangeOfTheBoard(x + 1, y + 1)
                && !lastCheckedFieldIsOccupied) {
            if (gameState.getFigureOn(x + 1, y + 1) != null) {
                lastCheckedFieldIsOccupied = true;

                if (gameState.getFigureOn(x + 1, y + 1).getSide() == gameState.getActualPlayer()) {
                    continue;
                }
            }

            results.add(new Coord(++x, ++y));
        }

        return results;
    }

    public List<Coord> listLShapeMovements() {
        List<Coord> results = new ArrayList<>();
        int[] yShiftValues = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] xShiftValues = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < xShiftValues.length; i++) {
            int x = getX() + xShiftValues[i];
            int y = getY() + yShiftValues[i];

            if (fieldIsWithinRangeOfTheBoard(x, y)) {
                Figure figure = gameState.getFigureOn(x, y);

                if (figure == null || figure.getSide() != gameState.getActualPlayer()) {
                    results.add(new Coord(x, y));
                }
            }
        }

        return results;
    }

    public List<Coord> listDiagonalLines() {
        List<Coord> results = new ArrayList<>();
        results.addAll(listSWDiagonalLine());
        results.addAll(listSEDiagonalLine());
        results.addAll(listNWDiagonalLine());
        results.addAll(listNEDiagonalLine());

        return results;
    }


    public List<Coord> listVerticalAndHorizontalLines() {
        List<Coord> results = new ArrayList<>();
        results.addAll(listEastHorizontalLine());
        results.addAll(listWestHorizontalLine());
        results.addAll(listNorthVerticalLine());
        results.addAll(listSouthVerticalLine());

        return results;
    }

    public List<Coord> listPawnMoves() {
        List<Coord> results = new ArrayList<>();
        int x = getX();
        int y = getY();
        int number = figure.isFirstMove() ? 2 : 1;
        results.addAll(listGivenNumberOfFieldsAhead(number));

        if (figure.getSide() == Side.WHITE) {
            if (gameState.getFigureOn(x - 1, y - 1) != null
                    && gameState.getFigureOn(x - 1, y - 1).getSide() == Side.BLACK) {
                results.add(new Coord(x - 1, y - 1));
            }
            if (gameState.getFigureOn(x + 1, y - 1) != null
                    && gameState.getFigureOn(x + 1, y - 1).getSide() == Side.BLACK) {
                results.add(new Coord(x + 1, y - 1));
            }
        } else {
            if (gameState.getFigureOn(x + 1, y + 1) != null
                    && gameState.getFigureOn(x + 1, y + 1).getSide() == Side.WHITE) {
                results.add(new Coord(x + 1, y + 1));
            }
            if (gameState.getFigureOn(x - 1, y + 1) != null
                    && gameState.getFigureOn(x - 1, y + 1).getSide() == Side.WHITE) {
                results.add(new Coord(x - 1, y + 1));
            }
        }

        return results;
    }

    public List<Coord> listGivenNumberOfFieldsAhead(int givenNumber) {
        List<Coord> results = new ArrayList<>();

        int x = getX();
        int y = getY();
        int i = 0;

        if (figure.getSide() == Side.WHITE) {
            while (i++ < givenNumber && (fieldIsWithinRangeOfTheBoard(x, y - 1))) {
                if (gameState.getFigureOn(x, y - 1) != null) {
                    break;
                }
                results.add(new Coord(x, --y));
            }
        } else {
            while (i++ < givenNumber && fieldIsWithinRangeOfTheBoard(x, y + 1)) {
                if (gameState.getFigureOn(x, y + 1) != null) {
                    break;
                }
                results.add(new Coord(x, ++y));
            }
        }

        return results;
    }

    public List<Coord> listMovesResultingToCheck(Figure figure, List<Coord> checkingMoves) {

        GameState tempGameState;

        for (Coord checkingMove : checkingMoves) {
            tempGameState = gameState;
            tempGameState.getFigureOn(figure.getX(), figure.getY())
                    .move(checkingMove.getX(), checkingMove.getY());
           // tempGameState.getFigureOn(figure.getX(), figure.getY()).getPossibleMoves().contains()

            for (Figure checkedFigure : listFiguresOfColor(figure.getSide(), tempGameState)) {
                checkedFigure.move(figure.getX(), figure.getY());
            }
        }

        List<Coord> results = new ArrayList<>();
        return results;
    }

    public List<Figure> listFiguresOfColor(Side color, GameState simulatedGameState) {
        List<Figure> results = new ArrayList<>();

        results = simulatedGameState.getFigures().stream()
                    .filter(figure -> figure.getSide() == color)
                    .collect(Collectors.toList());

        return results;
    }

    public boolean fieldIsOneFieldFarFromFigure(int i, int j) {
        int greaterX = Math.max(getX(), i);
        int lowerX = Math.min(getX(), i);
        int greaterY = Math.max(getY(), j);
        int lowerY = Math.min(getY(), j);

        return (greaterX - lowerX == 1 && greaterY - lowerY <= 1)
                || (greaterX - lowerX <= 1 && greaterY - lowerY == 1);
    }
}
