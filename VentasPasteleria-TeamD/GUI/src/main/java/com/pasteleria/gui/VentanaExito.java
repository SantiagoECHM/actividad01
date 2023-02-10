package com.pasteleria.gui;

import javafx.scene.control.Alert;

public class VentanaExito {
    private Alert alert;
    public VentanaExito(String mensaje, String titulo){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.show();
    }
}
