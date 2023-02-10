package com.pasteleria.gui.Venta;

import com.pasteleria.CONT.PastelesController;
import com.pasteleria.MOD.PastelEntidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class TablaInventario {
    private TableView<PastelEntidad> tablaInventario = new TableView<>();
    public ObservableList<PastelEntidad> pastelesInventario = FXCollections.observableArrayList();
    public TablaAgregados tablaAgregados;
    private Label lTotal;
    public TablaInventario(Label lTotal){
        this.lTotal=lTotal;
        PastelesController listaHelper = new PastelesController();
        pastelesInventario.addAll(listaHelper.ListarTodos());
        tablaInventario = new TableView<>();
        tablaInventario.getStyleClass().add("table-cell");
        tablaInventario.setPrefWidth(700);
        crearTabla();
    }

    private void crearTabla() {
        tablaInventario.setItems(pastelesInventario);
        TableColumn<PastelEntidad, String> colId= new TableColumn<PastelEntidad,String>("ID");
        TableColumn<PastelEntidad, String> colTipoPan= new TableColumn<PastelEntidad,String>("Tipo Pan");
        TableColumn<PastelEntidad, String> colRelleno = new TableColumn<PastelEntidad,String>("Relleno");
        TableColumn<PastelEntidad, Integer> colCantidad = new TableColumn<PastelEntidad,Integer>("Cantidad");
        TableColumn<PastelEntidad, Double> colPrecio = new TableColumn<PastelEntidad,Double>("Precio");
        TableColumn<PastelEntidad, Void> colColor = new TableColumn<PastelEntidad,Void>("Color");
        TableColumn<PastelEntidad, Void> colAgregar = new TableColumn<PastelEntidad,Void>("Agregar");

        colAgregar.setPrefWidth(130);
        colTipoPan.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colCantidad.setPrefWidth(120);
        colPrecio.setPrefWidth(120);
        colColor.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("idPastel"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("size"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("relleno"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Integer>("cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Double>("precio"));

        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory1 = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
            @Override
            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
                final TableCell<PastelEntidad,Void> cell1 = new TableCell<PastelEntidad,Void>(){
                    final Button boton =new Button("Agregar");
                    {
                        boton.setOnAction(evt->{
                            Stage stage = new Stage();
                            VentanaCantidad ventanaCantidad = new VentanaCantidad(getTableView().getItems().get(getIndex()), stage);
                            Scene scene = new Scene(ventanaCantidad, 400, 240);
                            stage.setTitle("Selecciona la cantidad");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.showAndWait();
                            if(ventanaCantidad.getResultado() == getTableView().getItems().get(getIndex()).getCantidad()) {
                                tablaAgregados.setPastel(getTableView().getItems().get(getIndex()));
                                getTableView().getItems().remove(getIndex());
                                lTotal.setText("Total: $" + tablaAgregados.getTotal());
                            }else{
                                PastelEntidad pastelModificado = new PastelEntidad(getTableView().getItems().get(getIndex()));
                                System.out.println("ID: "+pastelModificado.getIdPastel());
                                pastelModificado.setCantidad(ventanaCantidad.getResultado());
                                tablaAgregados.setPastel(pastelModificado);
                                PastelEntidad pastelOriginal = new PastelEntidad(getTableView().getItems().get(getIndex()));
                                int cant = pastelOriginal.getCantidad() - ventanaCantidad.getResultado();
                                System.out.println("Cantidad"+cant+"///");
                                System.out.println("Cantidad Ventana :"+ventanaCantidad.getResultado()+"///");
                                System.out.println("Cantidad pastel: "+pastelOriginal.getCantidad());
                                pastelOriginal.setCantidad(cant);
                                getTableView().getItems().add(getIndex()+1,pastelOriginal);
                                lTotal.setText("Total: $" + tablaAgregados.getTotal());
                                getTableView().getItems().remove(getIndex());
                                tablaInventario.refresh();
                            }
                        });
                        boton.setPrefWidth(80);
                        boton.setPrefHeight(10);
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(boton);
                        }
                    }


                };
                return  cell1;
            }
        };

        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory2 = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
            @Override
            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
                final TableCell<PastelEntidad,Void> cell2 = new TableCell<PastelEntidad,Void>(){
                    final Rectangle color = new Rectangle();
                    {

                        color.setWidth(80);
                        color.setHeight(10);
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
//                            String Scolor=getTableView().getItems().get(getIndex()).getColor();color.setFill(Color.web(Scolor));
//                            color.setFill(Color.web(Scolor));
//                            setGraphic(color);
                        }
                    }


                };
                return  cell2;
            }
        };

        colAgregar.setCellFactory(cellFactory1);
        colColor.setCellFactory(cellFactory2);
        tablaInventario.getColumns().addAll(colId,colTipoPan, colColor, colRelleno, colCantidad, colPrecio);
        tablaInventario.getColumns().add(colAgregar);
    }

    public TableView<PastelEntidad> getTablaInventario(){
        return tablaInventario;
    }

    public PastelEntidad getPastel(int index){
        return tablaInventario.getItems().get(index);
    }

    public void setTablaAgregados(TablaAgregados tablaAgregados) {
        this.tablaAgregados=tablaAgregados;
    }

    public void setPastel(PastelEntidad pastel){
        pastelesInventario.add(pastel);
    }

    public void setCambiarPastel(PastelEntidad pastel, Integer pocision){
        getPastel(pocision).setCantidad(getPastel(pocision).getCantidad()+pastel.getCantidad());
        tablaInventario.refresh();
    }

    public boolean removePastel(PastelEntidad pastelEntidad){
        return tablaInventario.getItems().removeIf(pastelEntidad1 -> (pastelEntidad.getIdPastel() == pastelEntidad1.getIdPastel()));
    }

    public boolean tieneEstePastel(PastelEntidad pastelEntidad) {
        for(int i = pastelesInventario.size()-1; i >= 0 ; i--){
            if(pastelesInventario.get(i).getIdPastel()== pastelEntidad.getIdPastel()) {
                System.out.println("Entro en tiene...");
                return true;
            }
        }
        return false;
    }

    public int posicionDelPastel(PastelEntidad pastelEntidad) {
        for(int i = pastelesInventario.size()-1; i >= 0 ; i--){
            if(pastelesInventario.get(i).getIdPastel()== pastelEntidad.getIdPastel()) {
                System.out.println("Entro en posicion...");
                return i;
            }
        }
        return 0;
    }

    public List<PastelEntidad> getListaPasteles() {
        return pastelesInventario;
    }
}
