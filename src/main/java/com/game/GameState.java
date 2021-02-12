package com.game;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    private Set<Figure> figures = new HashSet<>();

    public GameState() {
        FigureFactory figureFactory = new FigureFactory();
        figures.addAll(figureFactory.buildAllFigures());
    }

    public Set<Figure> getFigures() {
        return figures;
    }
}
