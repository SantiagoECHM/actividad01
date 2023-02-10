package com.pasteleria.gui.Venta;

import com.pasteleria.MOD.PastelEntidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.List;

public class TablaAgregados {
    private TableView<PastelEntidad> tablaAgregados = new TableView<>();
    private ObservableList<PastelEntidad> pastelesAgregados = FXCollections.observableArrayList();
    private TablaInventario tablaInventario;
    private Label lTotal;
    public TablaAgregados(Label lTotal){
        this.lTotal=lTotal;
        tablaAgregados = new TableView<>();
        tablaAgregados.getStyleClass().add("table-cell");
        tablaAgregados.setPrefWidth(700);
        crearTabla();
    }

    private void crearTabla() {
        tablaAgregados.setItems(pastelesAgregados);
        TableColumn<PastelEntidad, String> colId= new TableColumn<PastelEntidad,String>("ID");
        TableColumn<PastelEntidad, String> colTipoPan= new TableColumn<PastelEntidad,String>("Tipo Pan");
        TableColumn<PastelEntidad, Double> colPrecio = new TableColumn<PastelEntidad,Double>("Precio");
        TableColumn<PastelEntidad, Integer> colCantidad = new TableColumn<PastelEntidad,Integer>("Cantidad");
        TableColumn<PastelEntidad, Void> colColor = new TableColumn<PastelEntidad,Void>("Color");
        TableColumn<PastelEntidad, Void> colEliminar = new TableColumn<PastelEntidad,Void>("Eliminar");

        colEliminar.setPrefWidth(130);
        colTipoPan.setPrefWidth(120);
        colPrecio.setPrefWidth(120);
        colColor.setPrefWidth(100);
        colCantidad.setPrefWidth(50);

        colId.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("idPastel"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("tipoPan"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Double>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Integer>("cantidad"));

        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory1 = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
            @Override
            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
                final TableCell<PastelEntidad,Void> cell1 = new TableCell<PastelEntidad,Void>(){
                    final Button boton =new Button("Eliminar");
                    {
                        boton.setOnAction(evt->{
                            if(tablaInventario.tieneEstePastel(getTableView().getItems().get(getIndex()))){
                                tablaInventario.setCambiarPastel(getTableView().getItems().get(getIndex()), tablaInventario.posicionDelPastel(getTableView().getItems().get(getIndex())));
                                getTableView().getItems().remove(getIndex());

                            }else{
                                tablaInventario.setPastel(getTableView().getItems().get(getIndex()));
                                getTableView().getItems().remove(getIndex());
                            }
                            lTotal.setText("Total: $"+getTotal());
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
                            String Scolor=getTableView().getItems().get(getIndex()).getColor();color.setFill(Color.web(Scolor));
                            color.setFill(Color.web(Scolor));
                            setGraphic(color);
                        }
                    }


                };
                return  cell2;
            }
        };

        colEliminar.setCellFactory(cellFactory1);
        colColor.setCellFactory(cellFactory2);
        tablaAgregados.getColumns().addAll(colId,colTipoPan, colCantidad, colColor, colPrecio);
        tablaAgregados.getColumns().add(colEliminar);
    }

    public TableView<PastelEntidad> getTablaAgregados(){
        return tablaAgregados;
    }

    public void setTablaInventario(TablaInventario tablaInventario) {
        this.tablaInventario=tablaInventario;
    }

    public void setPastel(PastelEntidad pastel){
        pastelesAgregados.add(pastel);
    }

    public List<PastelEntidad> getListaPasteles(){
        return pastelesAgregados;
    }

    public Integer getTotal(){
        Integer total=0;
        for(int i = 0; i < pastelesAgregados.size(); i++){
            total+=(pastelesAgregados.get(i).getPrecio()*pastelesAgregados.get(i).getCantidad());
            System.out.println(pastelesAgregados.get(i).getPrecio()+"   " +pastelesAgregados.get(i).getCantidad());
        }
        return total;
    }
}
