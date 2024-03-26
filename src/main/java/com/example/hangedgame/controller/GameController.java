package com.example.hangedgame.controller;

import com.example.hangedgame.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;


public class GameController {
    @FXML
    private HBox hBoxCenter;

    @FXML
    private ImageView HangedRoll;

    @FXML
    private TextField leterTextField;

    private String Secret;

    private int cont;

    public void setWord(String Secret){
        this.Secret=Secret;
        initializeUI();
    }

    @FXML
    private void initializeUI(){
        cont = Secret.length();
        for (int i=0; i<cont;i++){
            Label label = new Label("");
            label.setAlignment(Pos.CENTER);
            label.setContentDisplay(ContentDisplay.CENTER);
            label.setPrefHeight(27.0);
            label.setPrefWidth(27.0);
            label.setStyle("-fx-border-color: black;");
            label.setTextAlignment(TextAlignment.CENTER);
            label.setId("label"+i);
            hBoxCenter.getChildren().add(label);
        }
    }

    @FXML
    void buttonTest(ActionEvent event) {
        System.out.println(Secret);
    }
    @FXML
    void onHandlerButtonEraser(ActionEvent event) {
        desbloquearTextField();
    }
    @FXML
    private void handleKeyTypedEvent(KeyEvent event) {
            if (leterTextField.getText().length() >= 1) {
                event.consume();
                bloquearTextField();
            }

    }
    private void bloquearTextField() {
        leterTextField.setEditable(false);
    }
    private void desbloquearTextField() {
        leterTextField.clear();
        leterTextField.setEditable(true);
    }
}