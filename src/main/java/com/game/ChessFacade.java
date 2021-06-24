package com.game;

import com.game.figures.Figure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ChessFacade {
    private GameState gameState;
    private BotLogic botLogic;

    public ChessFacade() {
        this.gameState = new GameState();
        botLogic = new BotLogic(gameState);
    }

    public Collection<Figure> getAll() {
        return new HashSet<>(gameState.getFigures());
    }


    public Collection<Move> getCorrectMovesFor(int x, int y) {
        //znalezc figure kliknieta
        //sprawdzic jej ruchy, czy na pewno kazdy moze wykonać tzn.
        //odsiac nieporawne ruchy takie jak:
        //ruchy niemozliwe bo nasza figura tam stoi (inna)
        //niemozliwe bo zasloniete przez inna figure
        //
        Figure figure = gameState.getFigureOn(x, y);
        if (figure == null) {
            return new ArrayList<>();
        }

        return figure.getPossibleMoves();
    }

    public boolean fieldIsOccupied(Figure checkedFigure, Coord possibleCoord) {
        if (checkedFigure.getX() == possibleCoord.getX()
                && checkedFigure.getY() == possibleCoord.getY()) {
            return true;
        }

        return false;
    }

    public Side actualPlayer() {
        return gameState.getActualPlayer();
    }

    public void move(Figure figure, int x, int y) {
        figure.move(x, y);
        gameState.nextPlayer();
    }

    public void attack(Figure attacker, int x, int y) {
        gameState.remove(x, y);
        System.out.println("PO USUNIECIU : " + gameState.getFigureOn(x,y));
        move(attacker, x, y);
    }

    public Move generateBestMove() {
        return botLogic.generateBestMove();
    }

    public Figure getFigureOn(int x, int y){
        return gameState.getFigureOn(x, y);
    }
}
