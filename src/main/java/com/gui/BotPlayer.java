package com.gui;

import com.game.ChessFacade;
import com.game.Coord;
import com.game.Move;

public class BotPlayer extends Player {
    private ChessFacade chessFacade;

    public BotPlayer(MouseManager mouseManager, ChessFacade chessFacade) {
        super(mouseManager);
        this.chessFacade = chessFacade;
    }

    @Override
    public void move() {
        mouseManager.setEnableClick(false);
        Move move = chessFacade.generateBestMove();
        mouseManager.reactToClickCoords(move.getFrom().getX(),move.getFrom().getY());
        mouseManager.reactToClickCoords(move.getTo().getX(),move.getTo().getY());
    }
}
