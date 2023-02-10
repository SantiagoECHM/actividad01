package com.pasteleria.gui;

import com.pasteleria.gui.Direccion.AgregarDireccion;
import com.pasteleria.gui.Menu.ContenedorGeneral;
import com.pasteleria.gui.Venta.PagarVenta;
import com.pasteleria.gui.Venta.TablaVentas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPruebas extends Application {
    public MainPruebas() {
    }

    public void start(Stage stage) throws IOException {
        Pane menu = new Login(stage);
        //SANTIAGO-CAMBIE ESTO
        Scene scene = new Scene(menu, 900.0, 500.0);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pastelería D'Baruch");
        stage.getIcons().add(new Image("icono.png"));
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}