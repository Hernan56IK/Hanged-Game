package com.example.hangedgame.view;

// Importaciones necesarias para la clase
import com.example.hangedgame.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

// Clase para la ventana del juego
public class GameStage extends Stage {
    // Controlador del juego
    private GameController gameController;

    // Constructor de la ventana del juego
    public GameStage() throws IOException {
        // Cargar el archivo FXML que define la interfaz gráfica del juego
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hangedgame/Game-view.fxml"));
        Parent root = loader.load();
        // Obtener el controlador del juego
        gameController = loader.getController();
        // Crear la escena y configurar la ventana
        Scene scene = new Scene(root);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/hangedgame/images/favicon.png"))));
        setResizable(false);
        setTitle("Ahorcado!");
        setScene(scene);
        show(); // Mostrar la ventana
    }

    // Método estático para obtener una instancia única de la ventana del juego
    public static GameStage getInstance() throws IOException {
        return GameStage.GameStageHolder.INSTANCE = new GameStage();
    }

    // Método estático para eliminar la instancia de la ventana del juego
    public static void deleteInstance() {
        GameStage.GameStageHolder.INSTANCE.close();
        GameStage.GameStageHolder.INSTANCE = null;
    }

    // Clase estática para almacenar la única instancia de la ventana del juego
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }

    // Método para obtener el controlador del juego
    public GameController getGameController() {
        return gameController;
    }
}
