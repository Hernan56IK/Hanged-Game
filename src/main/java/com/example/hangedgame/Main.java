package com.example.hangedgame;

import com.example.hangedgame.view.GameStage;
import com.example.hangedgame.view.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        WelcomeStage.getInstance();
    }
}
