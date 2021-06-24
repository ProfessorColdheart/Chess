package com.game;

import com.game.figures.Figure;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BotLogic {
    private GameState gameState;

    public BotLogic(GameState gameState) {
        this.gameState = gameState;
    }

    public Move generateBestMove() {

        List<Move> moves = gameState.getActualPlayersFigures().stream()
                .filter(figure -> figure.getPossibleMoves().size() > 0)
                .flatMap((figure -> figure.getPossibleMoves().stream()))
                .collect(Collectors.toList());
        Collections.shuffle(moves);

        if(moves.stream().anyMatch(move -> move.isAttack())) {
            return moves.stream().filter(move -> move.isAttack())
                    .findAny().get();
        }

        return moves.get(0);
       // return null; //gdy nie znaleziono żadnego dozwolonego ruchu
    }
}
