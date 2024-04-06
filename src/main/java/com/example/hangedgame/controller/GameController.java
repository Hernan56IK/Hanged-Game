package com.example.hangedgame.controller;

import com.example.hangedgame.model.Word;
import com.example.hangedgame.view.GameStage;
import com.example.hangedgame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public class GameController {

    //Hbox donde van a ir todos los label que van a mostrar las letras al acertar las letras de la palabra secreta
    @FXML
    private HBox hBoxCenter;

    //en este imageview se mostratan todas las imagenes del hombre ahorcado
    @FXML
    private ImageView HangedPos;

    //campo de texto donde se escribiran las letras para adivinar la palabra
    @FXML
    private TextField leterTextField;

    //Campo de texto que mostrara mensajes segun las acciones que haga el jugador
    @FXML
    private TextArea MesaggeArea;

    //variables donde se guarda la palabra secreta y la letra jugada
    private String Secret, letter;

    //variables de numero que serviran como contadores, vidas del jugador e intentos de la ayuda
    private int count, found, HangedNum, life = 6, close, helpNum=3;

    //label que mostrara las vidas restantes del jugador
    @FXML
    private Label CountLife;

    //boton de ayuda
    @FXML
    private Button ButtonHelp;

    //setea la palabra secreta que se recibe desde welcome controller y la guarda en mayuscula
    public void setWord(String Secret) {
        this.Secret = Secret.toUpperCase();
        initializeSW();
    }


    //inicializa los label donde se pondran las letras de la palabra secreta y les asigna propiedades ademas de guardarla en el Hbox center
    @FXML
    private void initializeSW() {
        count = Secret.length();
        for (int i = 0; i < count; i++) {
            Label label = new Label("");
            label.setAlignment(Pos.CENTER);
            label.setContentDisplay(ContentDisplay.CENTER);
            label.setPrefHeight(40.0);
            label.setPrefWidth(40.0);
            label.setStyle("-fx-border-color: black;-fx-font-weight: bold;-fx-font-size: 16px;");
            label.setTextAlignment(TextAlignment.CENTER);
            label.setId("label" + i);
            hBoxCenter.getChildren().add(label);
        }
    }

    //entrada de texto donde se escribira una letra para empezar a adivinar la palabra
    @FXML
    private void handleKeyTypedEvent(KeyEvent event) {
        if (leterTextField.getText().length() >= 1) {
            //event.consume();
            letter = leterTextField.getText().toUpperCase();
            bloquearTextField();
        }

    }

    //boton de borar que llama a funcion para desbloquear el campo de texto que acepta una sola letra y borra la letra almacenada
    @FXML
    void onHandlerButtonEraser(ActionEvent event) {

        desbloquearTextField();
    }

    //boton que se usa para buscar la letra ingresada en la palabra y segun las vidas o letras ingresadas cierra el programa
    @FXML
    void onHandlerButtonVerify(ActionEvent event) {
        searchLetter();
        closeProgram();
    }

    //boton de ayuda que arroja una letra de la palabra de forma aleatoria al jugador como ayuda
    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        int num =  Secret.length();
        int num2 = (int) (Math.random()*num);
        helpNum-=1;
        MesaggeArea.setText("La ayuda solicitada es: "+Secret.charAt(num2)+"\nAyudas restantes: "+helpNum);
        if (helpNum==0){ButtonHelp.setDisable(true);}

    }

    //bloque el campo de texto donde se escribe la letra para que no se puedan escribir mas letras
    private void bloquearTextField() {
        leterTextField.setEditable(false);
    }

    //desbloque y limpia el campo de texto donde se digita la letra
    private void desbloquearTextField() {
        leterTextField.clear();
        leterTextField.setEditable(true);
        letter = null;
    }

    //se encarga de comprobar que el caracter ingresa sea una letra y la busca en la palabra, en caso se ser un caracter especial arrojara una alerta de que el caracter no es valido
    private void searchLetter() {
        if (letter.matches("[a-zA-ZñÑ]+")) {
            for (int i = 0; i < Secret.length(); i++) {
                if (Secret.charAt(i) == letter.charAt(0)) {
                    ((Label) hBoxCenter.getChildren().get(i)).setText(letter);
                    found += 1;
                    MesaggeArea.setText("¡Letra encontrada!");
                }
            }
            if (found == 0) {
                HangedNum += 1;
                HangedPos.setImage(new Image(String.valueOf(getClass().getResource("/com/example/hangedgame/images/" + HangedNum + ".png"))));
                CountLife.setText(String.valueOf(life -= 1));
                MesaggeArea.setText("Letra incorrecta...");
            } else {
                found = 0;
            }
        } else {
            new AlertBox().showMessage("ERROR DE ESCRITURA", "El caracter ingresado no es valido", "Por favor digite una letra del abecedario");
        }
    }

    //si el jugador se queda sin vidas o si completa la palabra el programa arrojara una alertbox y cerrara el programa.
    private void closeProgram() {
        if (life == 0) {
            new AlertBox().showMessage("GAME OVER", "Te has quedado sin vidas", "Has perdido");
            GameStage.deleteInstance();
        } else {
            for (int i = 0; i < Secret.length(); i++) {
                String Empt = ((Label) hBoxCenter.getChildren().get(i)).getText();
                if (Empt != "") {
                    close += 1;
                }
            }
            if (close == Secret.length()) {
                new AlertBox().showConfirm("¡FELICITACIONES!", "Encontraste la palabra secreta, haz ganado", "Gracias por jugar, hasta luego");
                GameStage.deleteInstance();
            } else {
                close = 0;
            }
        }
    }

}