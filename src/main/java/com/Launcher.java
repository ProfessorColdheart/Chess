package com;

import com.gui.Presenter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Presenter presenter = new Presenter(stage);
        stage.show();
    }
}
