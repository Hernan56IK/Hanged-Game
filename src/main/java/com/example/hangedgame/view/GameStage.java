package com.example.hangedgame.view;

import com.example.hangedgame.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    private GameController gameController;
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hangedgame/Game-view.fxml"));
        Parent root = loader.load();
        gameController = loader.getController();
        Scene scene = new Scene(root);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/hangedgame/images/favicon.png"))));
        setResizable(false);
        setTitle("Ahorcado!");
        setScene(scene);
        show();
    }
    public static GameStage getInstance() throws IOException{
        return GameStage.GameStageHolder.INSTANCE = new GameStage();
    }

    public static void deleteInstance() {
        GameStage.GameStageHolder.INSTANCE.close();
        GameStage.GameStageHolder.INSTANCE = null;
    }

    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
    public GameController getGameController(){
        return gameController;
    }
}