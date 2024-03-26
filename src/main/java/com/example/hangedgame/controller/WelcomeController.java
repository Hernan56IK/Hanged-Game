package com.example.hangedgame.controller;



import com.example.hangedgame.model.Word;
import com.example.hangedgame.view.GameStage;
import com.example.hangedgame.view.WelcomeStage;
import com.example.hangedgame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;



public class WelcomeController {
    private String Secret;

    @FXML
    private TextField secretTextField;

    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        Secret = secretTextField.getText();
        if (Secret.matches("[a-zA-Z]+")) {
            new AlertBox().showConfirm("CONFIRMACION","La palabra es correcta","la palabra se ha guardado con exito");
            Word word=new Word(Secret);
            GameStage.getInstance().getGameController().setWord(Secret);
            WelcomeStage.deleteInstance();
        } else {
            new AlertBox().showMessage("ERROR DE ESCRITURA","La palabra ingresada contiene caracteres especiales no validos","Por favor ingresar solo letras");
        }

    }
}