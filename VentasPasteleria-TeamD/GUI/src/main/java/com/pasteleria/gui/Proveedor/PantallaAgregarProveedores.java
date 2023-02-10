package com.pasteleria.gui.Proveedor;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class PantallaAgregarProveedores extends GridPane{

    Button btnVolver;

    Label etiCod;
    Label etiNom;
    Label etiTel;
    Label etiCorr;
    TextField txtNom;
    TextField txtTel;
    TextField txtCorr;
    Button btnElim;
    Button btnAdd;
    ImageView imgEliminar;
    ImageView imgConfirmar;

    public PantallaAgregarProveedores(){

        getStylesheets().add(getClass().getResource("gui/styles.css").toExternalForm());
        setStyle("-fx-background-color: #ECF0F1;");
        inicializarComponentes();

    }
    private void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        etiCod = new Label("Código: ");

        etiNom = new Label("Nombre: ");
        txtNom = new TextField();

        etiCorr = new Label("Correo Electrónico: ");
        txtCorr = new TextField();

        etiTel = new Label("Telefono: ");
        txtTel = new TextField();

        imgEliminar = new ImageView("contenedor-de-basura.png");
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnElim = new Button();
        btnElim.setGraphic(imgEliminar);
        btnElim.setTooltip(new Tooltip("Eliminar proveedor"));

        imgConfirmar = new ImageView("correcto.png");
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAdd = new Button();
        btnAdd.setShape(new Circle(1.0));
        btnAdd.setGraphic(imgConfirmar);
        btnAdd.setTooltip(new Tooltip("Agregar proveedor"));

        //btnVolver.setOnAction(e->{
          //  LanzadorSecciones pantallaAnterior = new LanzadorSecciones(tabPane, tab);
           // tab.setContent(pantallaAnterior);
        //});

        this.add(etiCod, 2,0);

        this.add(etiNom, 1,1);
        this.add(txtNom, 2, 1);

        this.add(etiCorr,1,2);
        this.add(txtCorr, 2, 2);

        this.add(etiTel, 1, 3);
        this.add(txtTel, 2, 3);

        this.add(btnElim, 1, 4);
        this.add(btnAdd, 3, 4);

        //this.add(btnVolver, 6, 6);

    }
}
