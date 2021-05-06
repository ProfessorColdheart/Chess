package com.gui;

import javafx.scene.paint.Color;

enum ActionType {
    MOVE(Color.YELLOW.darker(), Color.YELLOW),
    SELECTED(Color.BLUE.darker(), Color.BLUE),
    ATTACK(Color.RED.darker(), Color.RED),
    NO_ACTION_WHITE(Color.LIGHTGREY, Color.WHITE),
    NO_ACTION_BLACK(Color.BROWN.darker(), Color.BROWN.brighter());

    private Color baseColor, hoveredColor;

    ActionType(Color baseColor, Color hoveredColor) {
        this.baseColor = baseColor;
        this.hoveredColor = hoveredColor;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public Color getHoveredColor() {
        return hoveredColor;
    }
}
