package com.game;

import com.game.figures.Figure;

public class BotLogic {
    private GameState gameState;

    public BotLogic(GameState gameState) {
        this.gameState = gameState;
    }

    public Coord[] generateBestMove() {
        for (Figure figure : gameState.getActualPlayersFigures()) {
            if (figure.getPossibleMoves().size() > 0) {
                Coord moveFrom = figure.getCoord();
                Coord moveTo = figure.getPossibleMoves().get(0);

                return new Coord[]{moveFrom, moveTo};
            }
        }
        return null; //gdy nie znaleziono żadnego dozwolonego ruchu
    }
}
