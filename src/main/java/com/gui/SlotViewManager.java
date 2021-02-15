package com.gui;

import com.game.Move;
import com.game.algorithm.findingpossiblemoves.FindingPossibleMoves;
import javafx.scene.layout.Pane;

public class SlotViewManager extends Pane implements HoverListener {
    public static final int SIZE = 50;
    private SlotView[][] figures;
    private HoverManager manager;

    public SlotViewManager(HoverManager manager) {
        this.manager = manager;
    }

    public SlotViewManager() {
        ViewsFactory factory = new ViewsFactory();
        figures = factory.prepareBoard();
    }

    public void reactToNewSlotHovered(HoverManager hoverManager) {
        SlotView actualHovered = hoverManager.getActualHovered();
        actualHovered.brightIn();

        SlotView lastHovered = hoverManager.getLastHovered();
        if (lastHovered != null) {
            lastHovered.brightOut();
        }

        if (actualHovered.getFigure() != null) {

            System.out.println("name: " + actualHovered.getFigure().getName());
            FindingPossibleMoves possibleMoves =
                    new FindingPossibleMoves(actualHovered.x, actualHovered.y);
            System.out.println(actualHovered.getFigure().getName());

            for (Move movementPossibility : possibleMoves.find(actualHovered.getFigure())) {
                hoverManager.findRectangleByCoordinates(
                        movementPossibility.getX(), movementPossibility.getY())
                        .brightIn();
            }

        }
    }

    public SlotView[][] getSlots() {
        return figures;
    }

}
