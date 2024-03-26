package com.example.hangedgame.view.alert;

public interface IAlertBox {
    void showMessage(String title, String header, String content);
    void showConfirm(String title, String header, String content);
}
