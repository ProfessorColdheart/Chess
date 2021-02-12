package com.gui;

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
    }

    public SlotView[][] getSlots() {
        return figures;
    }

}
