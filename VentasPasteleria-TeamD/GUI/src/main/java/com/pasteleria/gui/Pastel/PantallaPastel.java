package com.pasteleria.gui.Pastel;


import com.pasteleria.CONT.PastelesController;
import com.pasteleria.MOD.PastelEntidad;
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

public class PantallaPastel extends BorderPane {

    private Label titulo;
    private Button btnAgregarPastel;
    private HBox barra;
    private TableView tablaPasteles;
    private List<PastelEntidad> listaPastelHelper;
    private TextField filtro;
    private FilteredList<PastelEntidad> listaFiltro;
    TablaPasteles tablaPastelesHelper;
    TabPane tabPane;
    Tab tab;

    public PantallaPastel(TabPane tabPane, Tab tab){
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        this.tabPane = tabPane;
        this.tab = tab;
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {

        this.titulo = new Label("Pasteles");
        this.titulo.getStyleClass().add("label-titulo");
        this.titulo.setPrefHeight(70.0);

        PastelesController pastelControl = new PastelesController();
        listaPastelHelper = pastelControl.ListarTodos();

       tablaPastelesHelper = new TablaPasteles(listaPastelHelper);

        this.tablaPasteles = tablaPastelesHelper.getTablaPasteles();
        tablaPasteles.setMaxWidth(1000);

        tablaPasteles.setOnMouseClicked((evtm) -> {
            if (evtm.getClickCount() == 2) {
                PastelEntidad pastelSeleccionado = (PastelEntidad)tablaPasteles.getSelectionModel().getSelectedItem();
                int seleccion = tablaPasteles.getSelectionModel().getSelectedIndex();
                editarPastel(pastelSeleccionado, seleccion);
            }

        });

        this.btnAgregarPastel = new Button("Agregar Pastel");
        this.btnAgregarPastel.getStyleClass().add("cssBoton");
        this.btnAgregarPastel.setOnAction((evtm) -> {
            this.agregarPastel();
        });

        filtro=new TextField();
        //crear la lista del filtro agregando la lista de la tabla
        listaFiltro = new FilteredList<PastelEntidad>(tablaPastelesHelper.getListaPasteles(), b->true);
        //agregar listener al textfield
        filtro.textProperty().addListener((observable, oldvalue, newValue)->{
            listaFiltro.setPredicate(pastelEntidad -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFiltrer = newValue.toLowerCase();
                if(lowerCaseFiltrer.contains(Integer.toString(pastelEntidad.getIdPastel()))){
                    return true;
                }
                if(pastelEntidad.getRelleno().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(pastelEntidad.getEstadoPastel().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(pastelEntidad.getTipoPan().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(pastelEntidad.getSize().toLowerCase().contains(lowerCaseFiltrer)){
                    return true;
                }
                if(lowerCaseFiltrer.contains(Integer.toString(pastelEntidad.getCantidad()))){
                    return true;
                }
                if(lowerCaseFiltrer.contains(Integer.toString(pastelEntidad.getPrecio()))){
                    return true;
                }
                return false;
            });
        } );

        //envia la lista a la tabla
        SortedList<PastelEntidad> sortedData = new SortedList<PastelEntidad>(listaFiltro);
        sortedData.comparatorProperty().bind(tablaPasteles.comparatorProperty());
        tablaPasteles.setItems(sortedData);


        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(titulo, btnAgregarPastel, filtro);
        this.setTop(barra);
        this.setCenter(tablaPasteles);

    }

    private void editarPastel(PastelEntidad pastelSeleccionado, int seleccion) {
        Stage ventanaPastel = new Stage();
        Pane root = new AgregarPastel(ventanaPastel,seleccion, pastelSeleccionado,  tablaPastelesHelper);
        Scene escena = new Scene(root, 500, 500);
        ventanaPastel.setScene(escena);
        ventanaPastel.setResizable(false);
        ventanaPastel.setTitle("Pastel");
        ventanaPastel.show();

    }

    private void agregarPastel() {
        Stage ventanaPastel = new Stage();
        Pane root = new AgregarPastel(ventanaPastel, tablaPastelesHelper);
        Scene escena = new Scene(root, 500, 500);
        ventanaPastel.setScene(escena);
        ventanaPastel.setResizable(false);
        ventanaPastel.setTitle("Pastel");
        ventanaPastel.show();

    }


}
