package com.gui;

import javafx.scene.paint.Color;

import static com.gui.BoardManager.SIZE;

public class ViewsFactory {

    public SlotView[][] prepareBoard() {
        SlotView[][] slots = new SlotView[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Color color;
                if ((x + y) % 2 == 0) {
                    color = ActionType.NO_ACTION_WHITE.getBaseColor();
                } else {
                    color = ActionType.NO_ACTION_BLACK.getBaseColor();
                }
                FieldView fieldView = new FieldView(SIZE * x, SIZE * y, SIZE, SIZE, color);
                slots[y][x] = new SlotView(x, y, fieldView);
            }
        }

        return slots;
    }
}
