package com.pasteleria.gui.Ingrediente;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.time.LocalDate;

public class PantallaAgregarIngredientes extends GridPane {
    Label etiCod;
    Label etiNom;
    Label etiTipo;
    Label etiCant;
    Label etiCad;
    TextField txtNom;
    TextField txtTipo;
    TextField txtCant;
    DatePicker dtpCad;
    Button btnElim;
    Button btnAdd;
    ImageView imgEliminar;
    ImageView imgConfirmar;
    public PantallaAgregarIngredientes(){inicializarComponentes();}
    public void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        etiCod = new Label("Código: ");

        etiNom = new Label("Nombre: ");
        txtNom = new TextField();

        etiTipo = new Label("Tipo: ");
        txtTipo = new TextField();

        etiCant = new Label("Cantidad: ");
        txtCant = new TextField();

        etiCad = new Label("Caducidad: ");
        dtpCad = new DatePicker();
        dtpCad.setValue(LocalDate.now());

        imgEliminar = new ImageView("contenedor-de-basura.png");
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnElim = new Button();
        btnElim.setGraphic(imgEliminar);
        btnElim.setTooltip(new Tooltip("Eliminar ingrediente"));

        imgConfirmar = new ImageView("correcto.png");
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAdd = new Button();
        btnAdd.setShape(new Circle(1.0));
        btnAdd.setGraphic(imgConfirmar);
        btnAdd.setTooltip(new Tooltip("Agregar ingrediente"));

        this.add(etiCod, 2,0);

        this.add(etiNom, 1,1);
        this.add(txtNom, 2, 1);

        this.add(etiTipo,1,2);
        this.add(txtTipo, 2, 2);

        this.add(etiCant, 1, 3);
        this.add(txtCant, 2, 3);

        this.add(etiCad, 1, 4);
        this.add(dtpCad, 2, 4);

        this.add(btnElim, 1, 5);
        this.add(btnAdd, 3, 5);
    }
}
