package com.gui;

import com.game.figures.Figure;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Locale;

/**
 * Klasa reprezentująca widok figury na szachownicy
 */
public class SlotView extends ImageView {
    final protected int x, y;
    private final FieldView field;
    private Figure figure;

    public SlotView(int x, int y, FieldView field) {
        this.x = x;
        this.y = y;
        this.field = field;
        setTranslateX(x * BoardManager.SIZE);
        setTranslateY(y * BoardManager.SIZE);
    }

    public void updateField() {
        Image image = new Image(getFigureFilename());
        setImage(image);
        setTranslateX(x * BoardManager.SIZE);
        setTranslateY(y * BoardManager.SIZE);
        setFitHeight(BoardManager.SIZE);
        setFitWidth(BoardManager.SIZE);
    }

    public String getFigureFilename() {
        return figure.getName().name().toLowerCase(Locale.ROOT)
                + figure.getSide().name().toUpperCase(Locale.ROOT).charAt(0) + ".png";
    }

    public FieldView getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        updateField();
    }

    public void reactToActionIn(ActionType actionType) {
        field.reactToActionIn(actionType);
    }

    public void clearAction() {
        field.restoreColor();
    }

    public void setHovered(boolean isHovered) {
        field.setHovered(isHovered);
    }

    public int getColumnX() {
        return x;
    }

    public int getRowY() {
        return y;
    }

    public void moveTo(SlotView destination) {
        Path path = new Path();
        path.getElements().add(new MoveTo(getTranslateX() + BoardManager.SIZE * 0.5, getTranslateY() + BoardManager.SIZE * 0.5));
//        path.getElements().add(new LineTo(destination.getX(), destination.getY()));
        path.getElements().add(new LineTo(destination.getTranslateX() + BoardManager.SIZE * 0.5, destination.getTranslateY() + BoardManager.SIZE * 0.5));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(countDuration(destination));
        pathTransition.setNode(this);
        pathTransition.setPath(path);
        pathTransition.play();

        pathTransition.setOnFinished(event -> {
            destination.setFigure(figure);
            removeFigure();
        });


    }

    public Duration countDuration (SlotView destination) {
        double a = Math.abs(getTranslateX() - destination.getTranslateX()) + BoardManager.SIZE * 0.5;
        double b = Math.abs(getTranslateY() - destination.getTranslateY()) + BoardManager.SIZE * 0.5;
        System.out.println("Math.sqrt(a*a+b*b): " + Math.sqrt(a * a + b * b));
        return Duration.millis(Math.sqrt(a*a+b*b) * 5);
    }

    public void removeFigure() {
        this.figure = null;
        setImage(null);
        setTranslateX(x * BoardManager.SIZE);
        setTranslateY(y * BoardManager.SIZE);
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

