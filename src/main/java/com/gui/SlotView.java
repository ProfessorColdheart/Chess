package com.gui;

import com.game.Figure;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;

/**
 * Klasa reprezentująca widok figury na szachownicy
 */
public class SlotView extends ImageView {
    final protected int x, y;
    private Figure figure;
    private final FieldView field;

    public SlotView(int x, int y, FieldView field) {
        this.x = x;
        this.y = y;
        this.field = field;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        updateField();
    }

    public void updateField() {
        Image image = new Image(getFigureFilename());
        System.out.println("getFigureFilename(): " + getFigureFilename());
        setImage(image);
        setTranslateX(x * SlotViewManager.SIZE);
        setTranslateY(y * SlotViewManager.SIZE);
        setFitHeight(SlotViewManager.SIZE);
        setFitWidth(SlotViewManager.SIZE);
    }

    public String getFigureFilename() {
        return figure.getName().name().toLowerCase(Locale.ROOT)
                + figure.getSide().name().toUpperCase(Locale.ROOT).charAt(0) + ".png";
    }

    public FieldView getField() {
        return field;
    }

    public void brightIn() {
        field.brightIn();
    }

    public void brightOut() {
        field.brightOut();
    }

    @Override
    public String toString() {
        return "SlotView{" +
                "figure=" + figure +
                ", field=" + field +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
