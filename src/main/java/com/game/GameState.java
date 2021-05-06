package com.game;

import com.game.figures.Figure;

import java.util.*;
import java.util.stream.Collectors;

public class GameState {
    private List<Figure> figures = new ArrayList<>();
    private Side actualPlayer = Side.BLACK;


    public GameState() {
        FigureFactory figureFactory = new FigureFactory(this);
        figures.addAll(figureFactory.buildAllFigures());
    }

    public Collection<Figure> getFigures() {
        return figures;
    }
    public Collection<Figure> getActualPlayersFigures() {
        return figures.stream()
                .filter(figure -> figure.getSide().equals(actualPlayer))
                .collect(Collectors.toList());
    }

    public Figure getFigureOn(int x, int y){

        for (Figure figure : figures) {
          if (figure.getX() == x && figure.getY() == y) {
              return figure;
          }
        }
        return null;
    }

    public Side getActualPlayer() {
        return actualPlayer;
    }

    public void nextPlayer() {
        if (actualPlayer == Side.WHITE) {
            actualPlayer = Side.BLACK;
        } else {
            actualPlayer = Side.WHITE;
        }
    }

    public void remove(int x, int y) {
        figures.remove(getFigureOn(x, y));
    }
}
