package com.gui;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MoveIndicator extends ImageView {
    public MoveIndicator() {

        Image image = new Image("Red Lens Flare Line White.png");
        setImage(image);
//        view.setTranslateX(x * BoardManager.SIZE);
//        view.setTranslateY(y * BoardManager.SIZE);
        setFitHeight(BoardManager.SIZE * 2);
        setFitWidth(BoardManager.BOARD_SIZE);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), this);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(0.5);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), this);
        fadeOut.setFromValue(0.5);
        fadeOut.setToValue(0);

        SequentialTransition sequentialTransition = new SequentialTransition(this,fadeIn, fadeOut);
        //addNumbers(34, 5,6); // varargs demo
        sequentialTransition.setCycleCount(10);
        sequentialTransition.play();
    }
}
