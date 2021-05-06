package com.gui;

import com.game.Coord;

import java.util.ArrayList;
import java.util.List;

public class MouseManager {
    private final SlotView[][] slots;
    private final List<HoverListener> hoverListeners = new ArrayList<>();
    private final List<ClickListener> clickListeners = new ArrayList<>();
    private SlotView lastHovered;
    private SlotView actualHovered;
    private boolean enableClick = true;


    public MouseManager(SlotView[][] slots) {
        this.slots = slots;
    }

    public void reactToHover(double pixelX, double pixelY) {
        Coord coord = getMouseCoord(pixelX, pixelY);
        if (coord == Coord.INVALID_COORD) {
            return;
        }

        int x = coord.getX();
        int y = coord.getY();

        SlotView newSlot = findSlot(x, y);

        if (!newSlot.equals(actualHovered)) { // są inne?
            lastHovered = actualHovered;
            actualHovered = newSlot;
            for (HoverListener listener : hoverListeners) {
                listener.reactToNewSlotHovered(this);
                //listener.reactToNewSlotHovered(actualHovered);
            }
        }
    }


    public void reactToClickPixels(double pixelX, double pixelY) {
        if(!enableClick) {
            return;
        }
        Coord coord = getMouseCoord(pixelX, pixelY);
        if (coord == Coord.INVALID_COORD) {
            return;
        }
        int x = coord.getX();
        int y = coord.getY();
        reactToClickCoords(x,y);

    }

    public void reactToClickCoords( int x,int y ){
        SlotView newSlot = findSlot(x, y);
        for (ClickListener listener : clickListeners) {
            listener.reactToSlotClicked(newSlot);
        }
    }

    private Coord getMouseCoord(double pixelX, double pixelY) {
        int x = (int) (pixelX / BoardManager.SIZE);
        int y = (int) (pixelY / BoardManager.SIZE);

        if (x > 7 || y > 7 || x < 0 || y < 0) {
            return Coord.INVALID_COORD;
        }
        return new Coord(x, y);
    }

    public SlotView findSlot(int x, int y) {
        return slots[y][x];
    }

    public void registerHover(HoverListener listener) {
        hoverListeners.add(listener);
    }

    public void registerClick(ClickListener listener) {
        clickListeners.add(listener);
    }

    public SlotView getLastHovered() {
        return lastHovered;
    }

    public SlotView getActualHovered() {
        return actualHovered;
    }

    public void setEnableClick(boolean enableClick) {
        this.enableClick = enableClick;
    }
}
