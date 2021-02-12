package com.gui;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Klasa reprezentująca widok pola na szachownicy
 */
public class FieldView extends Rectangle {
    private static final Color BRIGHT_COLOR = Color.GRAY;
    private static final int BRIGHT_ANIMATION_TIME_MILLIS = 500;

    private final Color color;

    public FieldView(double x, double y, double width, double height, Color color) {
        super(x, y, width, height);
        this.color = color;
        setFill(color);
    }

    public void brightIn() {
        brightColor(color, BRIGHT_COLOR);
    }

    public void brightOut() {
        brightColor(BRIGHT_COLOR, color);
    }

    private void brightColor(Color from, Color to) {
        FillTransition transition = new FillTransition();
        transition.setShape(this);
        transition.setDuration(Duration.millis(BRIGHT_ANIMATION_TIME_MILLIS));
        transition.setFromValue(from);
        transition.setToValue(to);
        transition.play();
    }

}
