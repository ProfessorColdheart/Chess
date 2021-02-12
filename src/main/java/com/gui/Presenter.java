package com.gui;

import com.game.ChessFacade;
import com.game.Figure;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;

public class Presenter {
    private final SlotViewManager slotViewManager;
    private final Pane root = new Pane();
    private final ChessFacade chessFacade = new ChessFacade();
    private final SlotView[][] slots;

    private final Scene scene;

    public Presenter(Stage stage) {
        this.scene = new Scene(root);
        stage.setScene(scene);
        slotViewManager = new SlotViewManager();
        HoverManager hoverManager = new HoverManager(slotViewManager.getSlots());
        hoverManager.register(slotViewManager);
        root.getChildren().add(slotViewManager);
        slots = slotViewManager.getSlots();
        addAllSlots();
        setPiecesOnInitialPositions();
        prepareMouseListener(hoverManager);

    }

    private void addAllSlots() {
        System.out.println(Arrays.deepToString(slots));
        for (SlotView[] row : slots) {
            for (SlotView slot : row) {
                root.getChildren().add(slot.getField());
                root.getChildren().add(slot);
            }
        }
    }

    private void setPiecesOnInitialPositions() {
        for (Figure figure : chessFacade.getAll()) {
            slots[figure.getY()][figure.getX()].setFigure(figure);
        }
    }


    public void prepareMouseListener(HoverManager hoverManager) {
        scene.setOnMouseMoved(event -> {
            hoverManager.reactToHover(event.getX(), event.getY());
        });
    }
}
