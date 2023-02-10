package com.pasteleria.gui.Venta;


import com.pasteleria.MOD.PastelEntidad;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PantallaDetallesPastel extends GridPane {
    private PastelEntidad pastel;
    private Stage stage;
    private Label lPrecio;
    private Label lId;
    private Label lTamano;
    private Label lRelleno;
    private Label lTipo;
    private Label lColor;
    private Rectangle color;
    private Label lForma;
    private Label lNoPisos;
    public PantallaDetallesPastel(Stage stage, PastelEntidad pastel){
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        setStyle("-fx-background-color: #ecf0f1");
        this.stage=stage;
        this.pastel=pastel;
        lId = new Label("ID: "+pastel.getIdPastel());
        lTipo = new Label("Tipo pan: "+pastel.getTipoPan());
        lRelleno = new Label("Relleno: "+ pastel.getRelleno());
        lForma = new Label("Forma: " + pastel.getForma());
        lNoPisos = new Label("No pisos: "+ pastel.getNumPisos());
        lPrecio = new Label("Precio: $"+pastel.getPrecio());
        lTamano = new Label("Tamano: "+pastel.getSize());

        lColor = new Label("Color: ");
        color = new Rectangle();
        color.setFill(Color.web(pastel.getColor()));
        color.setHeight(20);
        color.setWidth(80);

        setVgap(20);
        setAlignment(Pos.CENTER);
        add(lId,1,1);
        add(lTipo,1,2);
        add(lForma,1,3);
        add(lColor,1,4);
        add(color,2,4);
        add(lNoPisos,1,5);
        add(lRelleno,1,6);
        add(lTamano,1,7);
        add(lPrecio,1,8);

    }
}
