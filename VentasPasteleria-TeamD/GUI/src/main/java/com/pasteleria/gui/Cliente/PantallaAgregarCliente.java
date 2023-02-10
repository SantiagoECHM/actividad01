package com.pasteleria.gui.Cliente;


import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PantallaAgregarCliente extends GridPane {


    private Stage stage;
    private Label lNombre;
    private Label lprimerApellido;
    private Label lsegApellido;
    private Label lTelefono;
    private Label lTelefonoRec;

    private TextField txtNombre;
    private TextField tprimerAp;
    private TextField tsegundoAp;
    private TextField tTelefono;
    private TextField tTelefono2;

    
    private int IDEstado;
    private int IDCiudad;
    private int IDColonia;

    private Button agregar;
    private int seleccion;
    private Label lCliente;

    public PantallaAgregarCliente(Stage stage) {
        this.stage = stage;
        this.seleccion = seleccion;
        this.lCliente = lCliente;
        setStyle("-fx-background-color: #dfe6e9");
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        lNombre = new Label("Nombre:  ");
        txtNombre = new TextField("");
        txtNombre.setPrefWidth(200);

        lprimerApellido = new Label("Primer apellido ");
        tprimerAp = new TextField("");
        tprimerAp.setPrefWidth(200);

        lsegApellido = new Label("Segundo apellido ");
        tsegundoAp = new TextField(" ");
        tsegundoAp.setPrefWidth(200);

        lTelefono = new Label("Numero telefonico ");
        tTelefono = new TextField("");
        tTelefono.setMaxWidth(280);

        lTelefonoRec = new Label("Numero de recuperacion ");
        tTelefono2 = new TextField();
       // tTelefono2.setPromptText("No. de la casa");
        tTelefono2.setMaxWidth(200);



       /* cbCiudad.setDisable(true);
        cbColonia.setDisable(true);
        tCalle.setDisable(true);
        tNoCasa.setDisable(true);
        tDetalles.setDisable(true);

        //crearListaCBEstado();

        cbEstado.setOnAction(evt -> {
            //accionCBEstado();
        });

        cbCiudad.setOnAction(evt -> {
            //accionCBCiudad();
        });

        cbColonia.setOnAction(evt -> {
            tCalle.setDisable(false);
        });

        tCalle.setOnMouseClicked(evt -> {
            tNoCasa.setDisable(false);
        });

        tNoCasa.setOnMouseClicked(evt -> {
            tDetalles.setDisable(false);
        });

        agregar = new Button("Agregar");
        agregar.getStyleClass().add("cssBoton");

        agregar.setOnAction(evt -> {
//            Direccion direccion=crearDireccion();
//            direcciones.agregarDireccion(direccion,seleccion);
//            direcciones.mostrarDirecciones();
            if (seleccion == 0) {
                lDireccion.setText("Direccion del cliente: " + cbEstado.getValue() + ", " + cbCiudad.getValue() + ", " + cbColonia.getValue() +
                        ", \n" + tCalle.getText() + ", " + tNoCasa.getText());
            }
            if (seleccion == 1) {
                lDireccion.setText("Direccion de entrega: " + cbEstado.getValue() + ", " + cbCiudad.getValue() + ", " + cbColonia.getValue() +
                        ", \n" + tCalle.getText() + ", " + tNoCasa.getText());
            }
            stage.close();
        });

        */
        setHgap(7);
        setVgap(7);
        setAlignment(Pos.CENTER);
        add(lNombre, 2, 0);
        add(txtNombre, 3, 0);
        add(lprimerApellido, 2, 2);
        add(tprimerAp, 3, 2);
        add(lsegApellido, 2, 4);
        add(tsegundoAp, 3, 4);
        add(lTelefono, 2, 6);
        add(tTelefono, 3, 6);
        add(lTelefonoRec, 2, 8);
        add(tTelefono2, 3, 8);
      //  add(lDescripcion, 2, 10);
       // add(tDetalles, 3, 10);
        add(agregar, 3, 11);
    }
    }



