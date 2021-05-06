package com.gui;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Klasa reprezentująca widok pola na szachownicy
 */
public class FieldView extends Rectangle {

    private static final int BRIGHT_ANIMATION_TIME_MILLIS = 500;
    private ActionType actualAction;
    private boolean hovered;

    private final ActionType baseAction;

    public FieldView(double x, double y, double width, double height, Color baseAction) {
        super(x, y, width, height);
        this.baseAction = baseAction == ActionType.NO_ACTION_WHITE.getBaseColor()
                ? ActionType.NO_ACTION_WHITE : ActionType.NO_ACTION_BLACK;
        setFill(baseAction);
        actualAction = this.baseAction;
    }

    public void reactToActionIn(ActionType actionType) {
        Color tempColor = getActualColor();
        actualAction = actionType;
        changeColor(tempColor, getActualColor());
    }

    private Color getBaseColor() {
        return hovered ? baseAction.getHoveredColor() : baseAction.getBaseColor();
    }

    private Color getActualColor() {
        return hovered ? actualAction.getHoveredColor() : actualAction.getBaseColor();
    }

    public void restoreColor() {
        changeColor(getActualColor(), getBaseColor());
        actualAction = baseAction;
    }

    private void changeColor(Color from, Color to) {
        FillTransition transition = new FillTransition();
        transition.setShape(this);
        transition.setDuration(Duration.millis(BRIGHT_ANIMATION_TIME_MILLIS));
        transition.setFromValue(from);
        transition.setToValue(to);
        transition.play();
    }

    public void setHovered(boolean isHovered) {
        Color actualColor = getActualColor();
        hovered = isHovered;
        Color newColor = getActualColor();
        changeColor(actualColor, newColor);
    }
}
