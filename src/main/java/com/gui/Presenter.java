package com.gui;

import com.game.ChessFacade;
import com.game.figures.Figure;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;

public class Presenter {
    private final BoardManager boardManager;
    private final Pane root = new Pane();
    private final ChessFacade chessFacade = new ChessFacade();
    private final SlotView[][] slots;


    private final Scene scene;

    public Presenter(Stage stage) {
        this.scene = new Scene(root);
        stage.setScene(scene);

        boardManager = new BoardManager(chessFacade);
        MouseManager mouseManager = new MouseManager(boardManager.getSlots());
        mouseManager.registerHover(boardManager);
        mouseManager.registerClick(boardManager);
        PlayersFactory playersFactory = new PlayersFactory(mouseManager, chessFacade);
        //boardManager.setPlayers(playersFactory.getPlayers(PlayerType.HUMAN, PlayerType.BOT));
        boardManager.setPlayers(playersFactory.getPlayers(PlayerType.BOT, PlayerType.HUMAN));
        root.getChildren().add(boardManager); //dodanie do drzewa FXowego powoduje renderowanie elementu
        slots = boardManager.getSlots();
        addAllSlots();
        setPiecesOnInitialPositions();
        prepareMouseListener(mouseManager);
        MoveIndicator indicatorLine = new MoveIndicator();
        root.getChildren().add(indicatorLine);
        boardManager.startGame();
    }

    private void addAllSlots() {
        System.out.println(Arrays.deepToString(slots));
        for (SlotView[] row : slots) {
            for (SlotView slot : row) {
                root.getChildren().add(slot.getField());
            }
        }

        for (SlotView[] row: slots) {
            for (SlotView slot : row) {
                root.getChildren().add(slot);
            }
        }
    }

    private void setPiecesOnInitialPositions() {
        for (Figure figure : chessFacade.getAll()) {
            slots[figure.getY()][figure.getX()].setFigure(figure);
        }
    }

    public void prepareMouseListener(MouseManager mouseManager) {
        scene.setOnMouseMoved(event ->
            mouseManager.reactToHover(event.getX(), event.getY()));
        scene.setOnMouseClicked(event ->
                mouseManager.reactToClickPixels(event.getX(), event.getY()));
    }

}