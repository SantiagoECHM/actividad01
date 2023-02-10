package com.pasteleria.gui;

import javafx.scene.control.Alert;

public class VentanaWaring {
    private Alert alert;
        public VentanaWaring(String mensaje, String titulo){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle(titulo);
            alert.setContentText(mensaje);
            alert.showAndWait();


        }

        public boolean resultado(){
            if(alert.getResult().getText().isEmpty())
                return false;
            else
                return alert.getResult().getText().equals("OK");
        }
}
