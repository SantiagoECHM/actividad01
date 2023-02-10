package com.pasteleria.gui;

import javafx.scene.control.Alert;

public class VentanaAlert{
    private Alert alert;
    public VentanaAlert(String mensaje, String titulo){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.show();
    }
}
