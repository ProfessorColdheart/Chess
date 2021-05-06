package com.gui;

import com.game.ChessFacade;

public class PlayersFactory {
   private MouseManager mouseManager;
   private ChessFacade chessFacade;

    public PlayersFactory(MouseManager mouseManager, ChessFacade chessFacade) {
        this.mouseManager = mouseManager;
        this.chessFacade = chessFacade;
    }

    public Player[] getPlayers(PlayerType playerAType, PlayerType playerBType) {
        Player playerA = (playerAType == PlayerType.HUMAN) ?
                new HumanPlayer(mouseManager) : new BotPlayer(mouseManager, chessFacade);
        Player playerB = (playerBType == PlayerType.BOT) ?
                new BotPlayer(mouseManager, chessFacade): new HumanPlayer(mouseManager);

        return new Player[]{playerA, playerB};
    }
}
