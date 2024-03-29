package com.example.hangedgame.controller;



import com.example.hangedgame.model.Word;
import com.example.hangedgame.view.GameStage;
import com.example.hangedgame.view.WelcomeStage;
import com.example.hangedgame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;


// Controlador para la ventana de bienvenida
public class WelcomeController {
    private String Secret;// Variable para almacenar la palabra secreta

    @FXML
    private TextField secretTextField;// Campo de texto para ingresar la palabra secreta

    // Método que maneja el evento del botón "Jugar"
    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        Secret = secretTextField.getText();// Obtiene la palabra ingresada por el usuario

        // Verifica si la palabra contiene solo letras (sin caracteres especiales)
        if (Secret.matches("[a-zA-ZñÑ]+")) {

            // Muestra una ventana de confirmación si la palabra es válida
            new AlertBox().showConfirm("CONFIRMACION","La palabra es correcta","la palabra se ha guardado con exito");

            // Crea un objeto Word con la palabra secreta
            Word word=new Word(Secret);

            // Establece la palabra en el controlador del juego
            GameStage.getInstance().getGameController().setWord(Secret);

            // Cierra la ventana de bienvenida
            WelcomeStage.deleteInstance();
        } else {

            // Muestra un mensaje de error si la palabra contiene caracteres especiales
            new AlertBox().showMessage("ERROR DE ESCRITURA","La palabra ingresada contiene caracteres especiales no validos","Por favor ingresar solo letras");
        }

    }
}