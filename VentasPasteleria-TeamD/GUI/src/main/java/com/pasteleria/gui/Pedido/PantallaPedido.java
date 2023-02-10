package com.pasteleria.gui.Pedido;

import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.CONT.VentasController;
import com.pasteleria.MOD.ClienteEntidad;
import com.pasteleria.MOD.DireccionEntidad;
import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.MOD.VentaEntidad;
import com.pasteleria.gui.Direccion.AgregarDireccion;
import com.pasteleria.gui.Pastel.AgregarPastel;
import com.pasteleria.gui.Pastel.TablaPasteles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class PantallaPedido extends BorderPane {
    private Label titulo;
    private HBox barra;
    private GridPane formulario;
    private GridPane gpDirecciones;
    private Button bAgregarPastel;
    private Button bAgregarDireccion1;
    private Button bRealizarPedido;
    private Label lAgregarPastel;
    private Label lAgregarDireccion1;
    private Label lRealizarPedido;
    private Label lTelefonoCliente;
    private Label lNombreCliente;
    private Label lApellidoPatCliente;
    private Label lApellidoMatCliente;
    private Label lTotal;
    private Label direccion1;
    private Label lfecha;
    private Label lHora;
    private TextField tTelefono;
    private TextField tNombre;
    private TextField tApellidoPat;
    private TextField tApellidoMat;
    private TablaPasteles tablaPasteles;
    private ObservableList<PastelEntidad> pasteles;
    public int total;
    private DireccionEntidad direccionEntrega;
    private DatePicker datePicker;
    private ComboBox<Integer> cbHora;
    private ComboBox<Integer> cbMinuto;
    private ComboBox<Integer> cbIdTrabajadores;
    private VentaEntidad ventaEntidad;
    private ClienteEntidad clienteEntidad;
    private DireccionEntidad direccionEntidad;
    TabPane tabPane;
    Tab tab;
    public PantallaPedido(TabPane tabPane, Tab tab){
        this.tabPane=tabPane;
        this.tab=tab;
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        formulario=new GridPane();
        barra=new HBox();

        titulo=new Label("Pedido");
        titulo.getStyleClass().add("label-titulo-Grande");

        pasteles= FXCollections.observableArrayList();
        tablaPasteles=new TablaPasteles(lTotal);
        TableView<PastelEntidad> tablaPasteles1=tablaPasteles.getTablaPasteles();
        tablaPasteles1.setPrefWidth(800);


//        direcciones=new Direcciones();

        lAgregarPastel=new Label("Agregar pastel:");
        bAgregarPastel=new Button("Agregar Pastel");
        bAgregarPastel.getStyleClass().add("cssBoton");
        bAgregarPastel.setOnAction(evt->{
            accionAgregarPastel();
        });
        direccion1=new Label("");
        lAgregarDireccion1=new Label("Direccion del cliente:");
        bAgregarDireccion1=new Button("Direccion cliente");
        bAgregarDireccion1.getStyleClass().add("cssBoton");
        direccionEntidad=new DireccionEntidad();
        bAgregarDireccion1.setOnAction(evt->{
            accionAgregarDireccion();
            System.out.println(direccionEntidad.toString());
        });




        lTelefonoCliente=new Label("Telefono del cliente: ");
        tTelefono=new TextField();
        tTelefono.setPromptText("Ingresa el numero");
        tTelefono.getStyleClass().add("text-field2");

        lNombreCliente=new Label("Nombre del cliente: ");
        tNombre=new TextField();
        tNombre.setPromptText("Teclea el nombre");
        tNombre.getStyleClass().add("text-field2");

        lApellidoPatCliente=new Label("Apellido Paterno: ");
        tApellidoPat=new TextField();
        tApellidoPat.setPromptText("Teclea el apellido Patero");
        tApellidoPat.getStyleClass().add("text-field2");

        lApellidoMatCliente=new Label("Apellido Materno: ");
        tApellidoMat=new TextField();
        tApellidoMat.setPromptText("Teclea el apellido materno");
        tApellidoMat.getStyleClass().add("text-field2");

        bRealizarPedido=new Button("Realizar pedido");
        bRealizarPedido.getStyleClass().add("cssBoton");
        bRealizarPedido.setOnAction(evtm->{

            if (comprobarCampos()){
                crearObjetos();
                pantallaPago();
            }
        });

        lTotal=new Label("Total: $"+total);
        lTotal.getStyleClass().add("label-titulo-Grande");

        lfecha = new Label("Selecciona la fecha de entrega");
        lHora= new Label("Selecciona la hora de entrega");

        datePicker = new DatePicker();
        datePicker.setPrefWidth(150);

        cbHora=new ComboBox<>();
        llenarCBHora();
        cbMinuto=new ComboBox<>();
        llenarCBMinuto();

        cbIdTrabajadores=new ComboBox<>();
        cbIdTrabajadores.getItems().addAll(new TrabajadoresController().CrearListaID());


        formulario.setStyle("-fx-background-color: #dfe6e9");
        formulario.setHgap(7);
        formulario.setVgap(7);
        formulario.setPrefWidth(500);
        formulario.add(lAgregarPastel,1,1);
        formulario.add(bAgregarPastel,2,1);
        formulario.add(lAgregarDireccion1,1,2);
        formulario.add(bAgregarDireccion1,2,2);
        formulario.add(lTelefonoCliente,1,3);
        formulario.add(tTelefono,1,4);
        formulario.add(lNombreCliente,1,5);
        formulario.add(tNombre,1,6);
        formulario.add(lApellidoPatCliente,1,7);
        formulario.add(tApellidoPat,1,8);
        formulario.add(lApellidoMatCliente,1,9);
        formulario.add(tApellidoMat,1,10);
        formulario.add(direccion1,1,11,2,2);
        formulario.add(lfecha,1,13);
        formulario.add(datePicker,2,13);
        formulario.add(lHora,1,17);
        formulario.add(cbHora,2,17);
        formulario.add(cbMinuto,2,18);
        formulario.add(cbIdTrabajadores,1,19);

        barra.setPrefHeight(80);
        barra.setSpacing(600);
        barra.alignmentProperty().set(Pos.CENTER);
        barra.getChildren().addAll(lTotal,bRealizarPedido);

        setRight(formulario);
        setLeft(tablaPasteles1);
        setTop(titulo);
        setBottom(barra);
        setAlignment(titulo,Pos.CENTER);
    }

    private void crearObjetos() {
        ventaEntidad=new VentaEntidad("pedido", new Time(cbHora.getValue()), new Date(datePicker.getValue().getYear(),
                datePicker.getValue().getMonth().getValue(), datePicker.getValue().getDayOfWeek().getValue()), "false",
                new TrabajadoresController().BuscarID(cbIdTrabajadores.getValue()));
        clienteEntidad=new ClienteEntidad(tNombre.getText(), tApellidoPat.getText(), tApellidoMat.getText(),
                tTelefono.getText());
    }

    private void llenarCBHora() {
        for(int i=0;i<25;i++)
            cbHora.getItems().add(i);
    }
    private void llenarCBMinuto() {
        for(int i=0;i<7;i++)
            cbMinuto.getItems().add(i*10);
    }


    private boolean comprobarCampos() {
        String str="";
        if(tablaPasteles.total()==0)
            str+="* No existen pasteles agregados\n";
        if(direccion1.getText().isEmpty())
            str+="* No tiene direccion de cliente agregada\n";
        if(tTelefono.getText().isEmpty())
            str+="* No se agrego un numero de telefono\n";
        if(cbHora.getSelectionModel().isEmpty())
            str+="* No se agrego una hora de entrega\n";
        if(cbMinuto.getSelectionModel().isEmpty())
            str+="* No se agrego la hora completa\n";
        if(tTelefono.getLength()>10 || tTelefono.getLength()<10) {
            str += "* Numero de telefono no valido\n";
        }else {
            char[] array= tTelefono.getText().toCharArray();
            for(char letra : array){
                if(!Character.isDigit(letra)){
                    str+="* El numero contiene letras\n";
                    break;
                }
            }
        }
        if(tNombre.getText().isEmpty())
            str+="* No se agrego nombre de cliente\n";
        if(str.isEmpty())
            return true;
        else
            ventanaAlerta(str);
        return false;
    }

    private void ventanaAlerta(String str) {
        Alert alertasalir = new Alert(Alert.AlertType.ERROR);
        alertasalir.setTitle("Error");
        alertasalir.setContentText("Hay errores en los datos favor de corregir:\n"+str);
        alertasalir.show();
        alertasalir.setHeight(300);
        alertasalir.setWidth(300);
    }

    private void pantallaPago() {
        Stage stage=new Stage();
        Pane menu = new PagarPedido(stage, tablaPasteles.total(),direccionEntidad, ventaEntidad, clienteEntidad, tablaPasteles.getListaPasteles());
        Scene scene = new Scene(menu, 400, 240);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pagar");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void accionAgregarDireccion() {
        Stage stage=new Stage();
        Pane menu = new AgregarDireccion(stage,direccion1, direccionEntidad);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Direccion");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
//        this.direccionEntrega1=menu.
    }

    private void accionAgregarPastel() {
        Stage stage=new Stage();
        AgregarPastel menu = new AgregarPastel(stage,tablaPasteles,lTotal);
        Scene scene = new Scene(menu, 700, 600);
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
