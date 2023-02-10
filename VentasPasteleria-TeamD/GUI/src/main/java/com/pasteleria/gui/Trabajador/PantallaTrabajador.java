package com.pasteleria.gui.Trabajador;

import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.MOD.TrabajadorEntidad;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PantallaTrabajador extends BorderPane {
    private Label lTitulo;
    private Button bAgregarUsuario;
    private HBox barra;
    private TableView<TrabajadorEntidad> tablaUsuarios;
    private TextField filtro;
    private FilteredList<TrabajadorEntidad> listaFiltro;
    private TabPane tabPane;
    private Tab tab;
    private ObservableList<TrabajadorEntidad> pasteles;
    private TablaTrabajador tablaTrabajadorHelper;

    public PantallaTrabajador(TabPane tabPane, Tab tab) {
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        this.tabPane = tabPane;
        this.tab = tab;
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        //Crea label del titulo
        this.lTitulo = new Label("Trabajadores");
        //Le da estilo
        this.lTitulo.getStyleClass().add("label-titulo");
        //Tamanio del label de titulo
        this.lTitulo.setPrefHeight(70.0);
        //crea la lista helper
        List<TrabajadorEntidad> listaTrabajadorHelper = new ArrayList<TrabajadorEntidad>();
        //crear controlador
        TrabajadoresController trabajadorControl = new TrabajadoresController();
        //agregar los elementos del controlador al la lista helper
        listaTrabajadorHelper = trabajadorControl.ListarTodos();
        //agregar la lista helper a la tabla helper
        tablaTrabajadorHelper = new TablaTrabajador(listaTrabajadorHelper);
        //a la tablaview agregarle la tabla helper
        this.tablaUsuarios = tablaTrabajadorHelper.getTablaUsuario();

        //metodo para crear ventana de editar entidad
        tablaUsuarios.setOnMouseClicked((evtm) -> {
            if (evtm.getClickCount() == 2) {
                TrabajadorEntidad usuarioSeleccionado = (TrabajadorEntidad)tablaUsuarios.getSelectionModel().getSelectedItem();
                int seleccion = tablaUsuarios.getSelectionModel().getSelectedIndex();
                editarTrabajador(usuarioSeleccionado, seleccion);
            }

        });

        //crear boton agregar
        this.bAgregarUsuario = new Button("Agregar Trabajador");
        this.bAgregarUsuario.getStyleClass().add("cssBoton");

        //metodo para ventana de crear entidad
        this.bAgregarUsuario.setOnAction((evtm) -> {
           this.crearUsuario();
        });

        //textfield para el filtro
        filtro=new TextField();
        //crear la lista del filtro agregando la lista de la tabla
        listaFiltro = new FilteredList<TrabajadorEntidad>(tablaTrabajadorHelper.getListaTrabajadores(), b->true);
        //agregar listener al textfield
        filtro.textProperty().addListener((observable, oldvalue, newValue)->{
            listaFiltro.setPredicate(trabajadorEntidad -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFiltrer = newValue.toLowerCase();
                if(lowerCaseFiltrer.contains(Integer.toString(trabajadorEntidad.getIdTrabajador()))){
                    return true;
                }
                if(trabajadorEntidad.getNombre().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(trabajadorEntidad.getPrimerApellido().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(trabajadorEntidad.getSegundoApellido().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(trabajadorEntidad.getTelefono().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(trabajadorEntidad.getTipo().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                return false;
            });
        } );

        //envia la lista a la tabla
        SortedList<TrabajadorEntidad> sortedData = new SortedList<TrabajadorEntidad>(listaFiltro);
        sortedData.comparatorProperty().bind(tablaUsuarios.comparatorProperty());
        tablaUsuarios.setItems(sortedData);

        //crear la barra superior y agregarlos al pane
        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(lTitulo, bAgregarUsuario, filtro);
        this.setTop(barra);
        this.setLeft(tablaUsuarios);
    }

    private void editarTrabajador(TrabajadorEntidad usuarioSeleccionado, int seleccion) {
        Stage ventanaUsuario = new Stage();
        Pane root = new PantallaAgregarTrabajador(ventanaUsuario, usuarioSeleccionado, seleccion, tablaTrabajadorHelper);
        Scene escena = new Scene(root, 600, 550);
        ventanaUsuario.setScene(escena);
        ventanaUsuario.setResizable(false);
        ventanaUsuario.setTitle("Editar Trabajador");
        ventanaUsuario.show();
    }

    private void crearUsuario(){
        Stage ventanaUsuario = new Stage();
        Pane root = new PantallaAgregarTrabajador(ventanaUsuario, tablaTrabajadorHelper);
        Scene escena = new Scene(root, 600, 550);
        ventanaUsuario.setScene(escena);
        ventanaUsuario.setResizable(false);
        ventanaUsuario.setTitle("Agregar Trabajador");
        ventanaUsuario.showAndWait();

    }


}