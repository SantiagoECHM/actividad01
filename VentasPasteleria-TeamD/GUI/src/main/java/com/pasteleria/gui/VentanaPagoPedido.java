package com.pasteleria.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class VentanaPagoPedido extends BorderPane {
    private Label ltotal;
    private Label lanticipo;
    private Label lrestante;
    private Label lmetPago;
    private Label titulo;

    private TextField total;
    private TextField anticipo;
    private TextField restante;

    private GridPane paneCentro;
    private GridPane paneBotones;

    private CheckBox efectivo;
    private CheckBox tarjeta;

    private Button btnConfirm;
    private Button btnCancel;
    private double totalDinero;
    private double pagoAnticipo;
    private double pagoRestante;
    private String restanteTotal;

    public VentanaPagoPedido (double totalDinero) {
        this.totalDinero = totalDinero;
        this.inicializarComponentes();
    }
    private void inicializarComponentes(){
        ltotal = new Label("Total: ");
        lanticipo = new Label("Anticipo :");
        lmetPago = new Label("Método de pago   ");
        titulo = new Label("Datos de pago");


        //String totalString = Double.toString(totalDinero);
        //  restanteTotal = Double.toString(obtenerRestante(89));
        total = new TextField("0");
        anticipo = new TextField("0");
        lrestante = new Label("Restante :");
        restante = new TextField(restanteTotal);
        efectivo = new CheckBox(" Efectivo ");
        tarjeta = new CheckBox(" Tarjeta ");
        btnConfirm = new Button("Confirmar");
        btnCancel = new Button("Cancelar");


        anticipo.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    if (!anticipo.equals("")) {
                        rellenarVariables();
                        pagoRestante = totalDinero - pagoAnticipo;
                        // pagoRestante = Double.parseDouble()
                        restante.setText("ola");

                    }
                }

            }

        });





    }

    private void rellenarVariables() {
        pagoAnticipo = Double.parseDouble(anticipo.getText());
        totalDinero = Double.parseDouble(total.getText());
    }
}
