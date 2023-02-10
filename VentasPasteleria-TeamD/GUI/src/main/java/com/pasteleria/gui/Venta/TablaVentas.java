package com.pasteleria.gui.Venta;

import com.pasteleria.MOD.PastelEntidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.List;

public class TablaVentas {
    private TableView<PastelEntidad> tablaPasteles;
    private ObservableList<PastelEntidad> pasteles= FXCollections.observableArrayList();
    private PastelEntidad pastel;
    public TablaVentas(List<PastelEntidad> listaPasteles){
        pasteles.addAll(listaPasteles);
        tablaPasteles = new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(700);
        crearTabla();
    }

    public void crearTabla() {
        tablaPasteles.setItems(pasteles);
        TableColumn<PastelEntidad, String> colId= new TableColumn<PastelEntidad,String>("ID");
        TableColumn<PastelEntidad, String> colTipoPan= new TableColumn<PastelEntidad,String>("Tipo Pan");
        TableColumn<PastelEntidad, String> colTamano = new TableColumn<PastelEntidad,String>("Tamaño");
        TableColumn<PastelEntidad, String> colRelleno = new TableColumn<PastelEntidad,String>("Relleno");
        TableColumn<PastelEntidad, Double> colPrecio = new TableColumn<PastelEntidad,Double>("Precio");
        TableColumn<PastelEntidad, Void> colColor = new TableColumn<PastelEntidad,Void>("Color");
        TableColumn<PastelEntidad, Void> colEliminar = new TableColumn<PastelEntidad,Void>("Eliminar");
        colEliminar.setPrefWidth(130);

        colTipoPan.setPrefWidth(120);
        colTamano.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colPrecio.setPrefWidth(120);
        colColor.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("id"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("tipoPan"));
        colTamano.setCellValueFactory(new PropertyValueFactory<PastelEntidad, String>("tamano"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("relleno"));
        //colColor.setCellValueFactory(new PropertyValueFactory<Pastel,Void>("color"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Double>("precio"));


        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory1 = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
            @Override
            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
                final TableCell<PastelEntidad,Void> cell1 = new TableCell<PastelEntidad,Void>(){
                    final Button boton =new Button("Eliminar");
                    {
                        boton.setOnAction(evt->{
                            getTableView().getItems().remove(getIndex());
                            //Pastel pastel = getTableView().getItems().get(getIndex());
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
            public TableCell<PastelEntidad, Void> call(final TableColumn<PastelEntidad,Void> param) {
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
        tablaPasteles.getColumns().addAll(colId,colTipoPan, colTamano, colColor, colRelleno, colPrecio);
        tablaPasteles.getColumns().add(colEliminar);
    }

    public void agregarPastel(PastelEntidad pastel,int seleccion){
        pasteles.remove(seleccion);
        pasteles.add(seleccion,pastel);
    }

    public void agregarPastel(PastelEntidad pastel){
        pasteles.add(pastel);
    }

    public void agregarPasteles(List<PastelEntidad> listaPasteles){
        for(int i = 0; i<listaPasteles.size(); i++){
            pasteles.add(listaPasteles.get(i));
        }

    }

    public TableView<PastelEntidad> getTablaPasteles(){
        return tablaPasteles;
    }

    public int total(){
        int total=0;
        for(int i=0; i<pasteles.size();i++){
            total+=pasteles.get(i).getPrecio();
        }
        return total;
    }

}
