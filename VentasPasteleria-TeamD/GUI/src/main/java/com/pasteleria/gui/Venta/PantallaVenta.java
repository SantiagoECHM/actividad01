package com.pasteleria.gui.Venta;

import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.gui.VentanaAlert;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class PantallaVenta extends BorderPane {
    private TablaInventario tablaInventario;
    private TablaAgregados tablaAgregados;
    private Label titulo;
    private Label lTotal;
    private Button bPagar;
    private HBox barra;
    private ComboBox<Integer> cbIdTrabajadores;
    TabPane tabPane;
    Tab tab;
    public PantallaVenta(TabPane tabPane, Tab tab) {
        this.tabPane = tabPane;
        this.tab = tab;
        lTotal = new Label("Total: $");
        lTotal.getStyleClass().add("label-titulo-Grande");

        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        lTotal = new Label("Total: $");
        lTotal.getStyleClass().add("label-titulo-Grande");

        tablaAgregados = new TablaAgregados(lTotal);
        TableView<PastelEntidad> tablaAgregados1 = tablaAgregados.getTablaAgregados();
        tablaAgregados1.setPrefWidth(600);
        tablaInventario = new TablaInventario(lTotal);
        TableView<PastelEntidad> tablaInventario1 = tablaInventario.getTablaInventario();
        tablaInventario1.setPrefWidth(750);

        tablaAgregados.setTablaInventario(tablaInventario);
        tablaInventario.setTablaAgregados(tablaAgregados);

        tablaAgregados1.setOnMouseClicked(evtm->{
            if(evtm.getClickCount()==2){
                int index = tablaAgregados1.getSelectionModel().getSelectedIndex();
                PastelEntidad pastel= tablaAgregados1.getItems().get(index);
                crearPantallaDetalles(tablaAgregados1.getSelectionModel().getSelectedIndex(), pastel);
            }
        });


        tablaInventario1.setOnMouseClicked(evtm->{
            if(evtm.getClickCount()==2){
                int index = tablaInventario1.getSelectionModel().getSelectedIndex();
                PastelEntidad pastel= tablaInventario1.getItems().get(index);
                crearPantallaDetalles(tablaInventario1.getSelectionModel().getSelectedIndex(), pastel);
            }
        });

        barra = new HBox();

        bPagar = new Button("Pagar");
        bPagar.getStyleClass().add("botonAzul");
        bPagar.setOnAction(evtm->{
            String errores="";
            if(tablaAgregados1.getItems().isEmpty()){
                errores+="No existen pasteles agregados";
            }
            if(cbIdTrabajadores.getSelectionModel().isEmpty()){
                errores+="No se selecciono el ID del trabajador";
            }
            if(errores.equals("")){
                Integer total = tablaAgregados.getTotal();
                crearPantallaVenta(total);
            }else {
                VentanaAlert ventanaAlert = new VentanaAlert(errores, "Error al crear venta");
            }
        });

        titulo = new Label("Venta");
        titulo.getStyleClass().add("label-titulo-Grande");
        setAlignment(titulo, Pos.CENTER);
        titulo.setPrefHeight(90);
        HBox tablas = new HBox(tablaAgregados1, tablaInventario1);

        cbIdTrabajadores=new ComboBox<>();
        cbIdTrabajadores.getItems().addAll(new TrabajadoresController().CrearListaID());

        barra.getChildren().addAll(lTotal, bPagar, cbIdTrabajadores);
        barra.setAlignment(Pos.CENTER_LEFT);
        barra.setPadding(new Insets(20,100,10,100));
        barra.setSpacing(140);
        barra.setPrefHeight(80);
        setBottom(barra);
        setTop(titulo);
        setCenter(tablas);

    }

    private void crearPantallaVenta(Integer total) {
        Stage stage = new Stage();
        Pane detalles = new PagarVenta(stage, total, cbIdTrabajadores.getSelectionModel().getSelectedItem(), tablaAgregados.getListaPasteles(), tablaInventario.getListaPasteles());
        Scene scene = new Scene(detalles, 400, 240);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearPantallaDetalles(int selectedIndex, PastelEntidad pastel) {
        Stage stage = new Stage();
        Pane detalles = new PantallaDetallesPastel(stage, pastel);
        Scene scene = new Scene(detalles, 350, 400);
        stage.setTitle("Detalles del pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}