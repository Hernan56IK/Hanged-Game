package com.example.hangedgame.view.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert;

// Clase que implementa la interfaz IAlertBox para mostrar mensajes de alerta
public class AlertBox implements IAlertBox {

    // Método para mostrar un mensaje de error
    @Override
    public void showMessage(String title, String header, String content) {
        // Crear una ventana de alerta de tipo ERROR
        Alert alert = new Alert(Alert.AlertType.ERROR);
        // Establecer el título, encabezado y contenido del mensaje
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        // Mostrar la ventana de alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }

    // Método para mostrar un mensaje de confirmación
    @Override
    public void showConfirm(String title, String header, String content) {
        // Crear una ventana de alerta de tipo INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Establecer el título, encabezado y contenido del mensaje
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        // Mostrar la ventana de alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }
}
