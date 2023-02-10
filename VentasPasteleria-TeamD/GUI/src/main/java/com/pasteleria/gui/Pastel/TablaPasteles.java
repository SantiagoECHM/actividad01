package com.pasteleria.gui.Pastel;

import com.pasteleria.MOD.PastelEntidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.List;


public class TablaPasteles {
    private TableView<PastelEntidad> tablaPasteles;
    private ObservableList<PastelEntidad> pasteles= FXCollections.observableArrayList();
    private PastelEntidad pastel;
    private Label lTotal;
    public TablaPasteles(Label lTotal){
        this.lTotal=lTotal;
        tablaPasteles = new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(700);
        crearTabla();
    }

    public TablaPasteles(List<PastelEntidad> listaPasteles){
        this.pasteles.addAll(listaPasteles);
        tablaPasteles = new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(700);
        crearTabla();
    }

    public void crearTabla() {
        tablaPasteles.setItems(pasteles);
        TableColumn<PastelEntidad, Integer> colID= new TableColumn<PastelEntidad,Integer>("ID");
        TableColumn<PastelEntidad, String> colTipoPan= new TableColumn<PastelEntidad,String>("Tipo Pan");
        TableColumn<PastelEntidad, String> colTamano = new TableColumn<PastelEntidad,String>("Tamanio");
        TableColumn<PastelEntidad, String> colRelleno = new TableColumn<PastelEntidad,String>("Relleno");
        TableColumn<PastelEntidad, Integer> colCantidad = new TableColumn<PastelEntidad,Integer>("Cantidad");
        TableColumn<PastelEntidad, Integer> colPrecio = new TableColumn<PastelEntidad,Integer>("Precio");


        colID.setPrefWidth(130);
        colTipoPan.setPrefWidth(200);
        colTamano.setPrefWidth(200);
        colRelleno.setPrefWidth(200);
        colCantidad.setPrefWidth(200);
        colPrecio.setPrefWidth(200);

        colID.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Integer>("idPastel"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("TipoPan"));
        colTamano.setCellValueFactory(new PropertyValueFactory<PastelEntidad, String>("Size"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<PastelEntidad,String>("Relleno"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Integer>("Cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<PastelEntidad,Integer>("Precio"));


        //        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
//            @Override
//            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
//                final TableCell<PastelEntidad,Void> cell = new TableCell<PastelEntidad,Void>(){
//                    final Button boton =new Button("Eliminar");
//                    {
//                        boton.setOnAction(evt->{
//                            getTableView().getItems().remove(getIndex());
//                        });
//                        boton.setPrefWidth(80);
//                        boton.setPrefHeight(10);
//                    }
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(boton);
//                        }
//                    }
//
//
//                };
//                return  cell;
//            }
//        };
//
//        Callback<TableColumn<PastelEntidad,Void>, TableCell<PastelEntidad,Void>> cellFactory2 = new Callback<TableColumn<PastelEntidad, Void>, TableCell<PastelEntidad, Void>>() {
//            @Override
//            public TableCell<PastelEntidad,Void>  call(final TableColumn<PastelEntidad,Void> param) {
//                final TableCell<PastelEntidad,Void> cell2 = new TableCell<PastelEntidad,Void>(){
//                    final Rectangle color = new Rectangle();
//                    {
//
//                        color.setWidth(70);
//                        color.setHeight(10);
//                    }
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            String Scolor=getTableView().getItems().get(getIndex()).getColor();color.setFill(Color.web(Scolor));
//                            color.setFill(Color.web(Scolor));
//                            setGraphic(color);
//                        }
//                    }
//
//
//                };
//                return  cell2;
//            }
//        };

//        colEliminar.setCellFactory(cellFactory);
//        colColor.setCellFactory(cellFactory2);


        tablaPasteles.getColumns().addAll(colTipoPan,colTamano,colRelleno, colCantidad,
                colPrecio);
//        tablaPasteles.getColumns().add(colEliminar);
    }

    public void agregarPastel(PastelEntidad pastel){
        pasteles.add(pastel);
    }

    public void agregarPastel(PastelEntidad pastel, int seleccion){
        pasteles.remove(seleccion);
        pasteles.add(seleccion, pastel);
        tablaPasteles.refresh();
    }
    public void agregarPasteles(List<PastelEntidad> listaPasteles){
        for(int i = 0; i<listaPasteles.size(); i++){
            pasteles.add(listaPasteles.get(i));
        }

    }

    public void eliminarPastel(PastelEntidad pastel){
        pasteles.remove(pastel);
        tablaPasteles.refresh();
    }

    public TableView<PastelEntidad> getTablaPasteles(){
        return tablaPasteles;
    }

    public ObservableList<PastelEntidad> getListaPasteles(){
        return pasteles;
    }

    public int total(){
        int total=0;
        for(int i=0; i<pasteles.size();i++){
            total+=pasteles.get(i).getPrecio();
        }
        return total;
    }

}
