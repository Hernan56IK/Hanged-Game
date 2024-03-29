package com.example.hangedgame.view;

// Importaciones necesarias para la clase
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

// Clase para la ventana de bienvenida
public class WelcomeStage extends Stage {
    // Constructor de la ventana de bienvenida
    public WelcomeStage() throws IOException {
        // Cargar el archivo FXML que define la interfaz gráfica de la ventana de bienvenida
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hangedgame/Welcome-view.fxml"));
        Parent root = loader.load();
        // Crear la escena y configurar la ventana
        Scene scene = new Scene(root);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/hangedgame/images/favicon.png"))));
        setResizable(false);
        setTitle("Ahorcado!");
        setScene(scene);
        show(); // Mostrar la ventana
    }

    // Método estático para obtener una instancia única de la ventana de bienvenida
    public static WelcomeStage getInstance() throws IOException {
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }

    // Método estático para eliminar la instancia de la ventana de bienvenida
    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }

    // Clase estática para almacenar la única instancia de la ventana de bienvenida
    private static class WelcomeStageHolder {
        private static WelcomeStage INSTANCE;
    }
}
