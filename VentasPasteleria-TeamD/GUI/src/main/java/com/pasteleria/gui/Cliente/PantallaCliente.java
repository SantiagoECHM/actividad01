package com.pasteleria.gui.Cliente;

import com.pasteleria.CONT.ClientesController;
import com.pasteleria.MOD.ClienteEntidad;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class PantallaCliente extends BorderPane {

    private Label titulo;

    private Button btnEditarCliente;

    private HBox barra;

    private TableView tablaClientes;

    private TextField filtro;
    private FilteredList<ClienteEntidad> listaFiltro;
    private List<ClienteEntidad> listaClienteHelper;
    private TablaCliente tablaClienteHelper;
    private TabPane tabPane;
    private Tab tab;

    public PantallaCliente(TabPane tabPane, Tab tab) {
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        this.tabPane = tabPane;
        this.tab = tab;
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.titulo = new Label("Clientes");
        this.titulo.getStyleClass().add("label-titulo");
        this.titulo.setPrefHeight(70.0);

        //List<ClienteEntidad>listaClienteHelper = new ArrayList<ClienteEntidad>();
        ClientesController clienteControl = new ClientesController();
        listaClienteHelper = clienteControl.ListarTodos();

        tablaClienteHelper = new TablaCliente(listaClienteHelper);

        this.tablaClientes=tablaClienteHelper.getTablaClientes();
        tablaClientes.setMaxWidth(1000.0);
        tablaClientes.setOnMouseClicked((evtm)->{
            if (evtm.getClickCount()==2){
                ClienteEntidad clienteSeleccionado =(ClienteEntidad) tablaClientes.getSelectionModel().getSelectedItem();
                int seleccion = tablaClientes.getSelectionModel().getSelectedIndex();
                editarCliente(clienteSeleccionado, seleccion);
            }
        });

        /*this.btnEditarCliente = new Button("Editar Cliente");
        this.btnEditarCliente.getStyleClass().add("cssBoton");

        this.btnEditarCliente.setOnAction(evtm->{
            ClienteEntidad clienteSeleccionado =(ClienteEntidad) tablaClientes.getSelectionModel().getSelectedItem();
            int seleccion = tablaClientes.getSelectionModel().getSelectedIndex();
            editarCliente(clienteSeleccionado, seleccion);
        });*/

        filtro=new TextField();
        listaFiltro = new FilteredList<ClienteEntidad>(tablaClienteHelper.getListaClientes(), b->true);
        filtro.textProperty().addListener((observable, oldvalue, newValue)->{
            listaFiltro.setPredicate(clienteEntidad -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFiltrer = newValue.toLowerCase();
                if(lowerCaseFiltrer.contains(Integer.toString(clienteEntidad.getIdCliente()))){
                    return true;
                }
                if(clienteEntidad.getNombreCliente().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(clienteEntidad.getPrimerApellido().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(clienteEntidad.getSegundoApellido().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(clienteEntidad.getTelefono().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(clienteEntidad.getTelRecuperacion().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                return false;
            });
        } );

        SortedList<ClienteEntidad> sortedData = new SortedList<ClienteEntidad>(listaFiltro);
        sortedData.comparatorProperty().bind(tablaClientes.comparatorProperty());
        tablaClientes.setItems(sortedData);

        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(titulo, filtro);
        this.setTop(barra);
        this.setCenter(tablaClientes);
    }
    private void editarCliente(ClienteEntidad clienteSeleccionado, int seleccion) {
       Stage ventanaCliente = new Stage();
       Pane root = new EditarCliente(ventanaCliente, clienteSeleccionado, seleccion, tablaClienteHelper);
       Scene escena = new Scene(root, 600, 600);
       escena.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
       ventanaCliente.setScene(escena);
       ventanaCliente.setResizable(false);
       ventanaCliente.setAlwaysOnTop(true);
       ventanaCliente.setTitle("Cliente");
       ventanaCliente.setAlwaysOnTop(true);
       ventanaCliente.show();
    }
    /*private void editarCliente(ClienteEntidad clienteSeleccionado, int seleccion){
        Stage ventanaCliente = new Stage();
        Pane root = new (ventanaCliente, seleccion, clienteSeleccionado, tablaClientes);
    }*/
}
