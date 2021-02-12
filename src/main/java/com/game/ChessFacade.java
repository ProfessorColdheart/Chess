package com.game;

import java.util.Collection;
import java.util.HashSet;

public class ChessFacade {
    private GameState gameState;

    public ChessFacade() {
        this.gameState = new GameState();
    }

    public Collection<Figure> getAll() {
        return new HashSet<>(gameState.getFigures());
    }
}
