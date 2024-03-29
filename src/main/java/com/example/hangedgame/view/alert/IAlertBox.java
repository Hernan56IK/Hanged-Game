package com.example.hangedgame.view.alert;

// Interfaz para definir métodos de mostrar mensajes de alerta
public interface IAlertBox {
    // Método para mostrar un mensaje informativo
    void showMessage(String title, String header, String content);

    // Método para mostrar un mensaje de confirmación
    void showConfirm(String title, String header, String content);
}
