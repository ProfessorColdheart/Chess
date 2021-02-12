package com.gui;

import java.util.ArrayList;
import java.util.List;

public class HoverManager {
    private final SlotView[][] slots;
    private SlotView lastHovered;
    private SlotView actualHovered;
    private final List<HoverListener> listeners = new ArrayList<>();


    public HoverManager(SlotView[][] slots) {
        this.slots = slots;
    }

    public void reactToHover(double pixelX, double pixelY) {
        int x = (int) (pixelX / SlotViewManager.SIZE);
        int y = (int) (pixelY / SlotViewManager.SIZE);

        SlotView newSolt = findRectangleByCoordinates(x, y);

        if (!newSolt.equals(actualHovered)) { // są inne?
            lastHovered = actualHovered;
            actualHovered = newSolt;
            for (HoverListener listener : listeners) {
                listener.reactToNewSlotHovered(this);
            }
        }
    }

    public SlotView findRectangleByCoordinates(int x, int y) {
        return slots[y][x];
    }

    public void register(HoverListener listener) {
        listeners.add(listener);
    }

    public SlotView getLastHovered() {
        return lastHovered;
    }

    public SlotView getActualHovered() {
        return actualHovered;
    }
}
