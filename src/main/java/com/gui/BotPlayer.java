package com.gui;

import com.game.ChessFacade;
import com.game.Coord;

public class BotPlayer extends Player {
    private ChessFacade chessFacade;

    public BotPlayer(MouseManager mouseManager, ChessFacade chessFacade) {
        super(mouseManager);
        this.chessFacade = chessFacade;
    }

    @Override
    public void move() {
        mouseManager.setEnableClick(false);
        Coord[] bestMove = chessFacade.generateBestMove();
        mouseManager.reactToClickCoords(bestMove[0].getX(), bestMove[0].getY());
        mouseManager.reactToClickCoords(bestMove[1].getX(), bestMove[1].getY());

        //todo
    }
}
