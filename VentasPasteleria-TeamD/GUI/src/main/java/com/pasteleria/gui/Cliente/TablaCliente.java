package com.pasteleria.gui.Cliente;

import com.pasteleria.MOD.ClienteEntidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TablaCliente {

    private TableView<ClienteEntidad> tablaClientes;

    private ObservableList<ClienteEntidad> clientes = FXCollections.observableArrayList();
    private ClienteEntidad cliente;
    public TablaCliente(List<ClienteEntidad> listaClientes){
        this.clientes.addAll(listaClientes);
        this.tablaClientes = new TableView<>();
        this.tablaClientes.getStyleClass().add("table-cell");
        this.tablaClientes.setPrefWidth(700.0);
        this.crearTabla();
    }
//eliminar, buscar, editar
    private void crearTabla() {
        this.tablaClientes.setItems(clientes);

        TableColumn<ClienteEntidad, Integer> colId = new TableColumn<ClienteEntidad, Integer>("ID");
        TableColumn<ClienteEntidad, String> colNombre = new TableColumn<ClienteEntidad, String>("Nombre");
        TableColumn<ClienteEntidad, String> colPrimerApellido = new TableColumn<ClienteEntidad, String>("Primer Apellido");
        TableColumn<ClienteEntidad, String> colSegundoApellido = new TableColumn<ClienteEntidad, String>("Segundo Apellido");
        TableColumn<ClienteEntidad, String> colTelefono = new TableColumn<ClienteEntidad, String>("Telefono");
        TableColumn<ClienteEntidad, String> colTelefono2 = new TableColumn<ClienteEntidad, String>("Telefono 2");
        //TableColumn<ClienteEntidad, String> colDireccion_IDDireccion = new TableColumn<ClienteEntidad, String>("IDir");
        //TableColumn<ClienteEntidad, Void> colEliminar = new TableColumn<ClienteEntidad, Void>("Eliminar");
        /*
        //¿Debería incluir el ID de la dirección y la venta?
        TableColumn<ClienteEntidad, String> colDetalles = new TableColumn<ClienteEntidad, String>("Detalles");
        TableColumn<ClienteEntidad, Void> colEliminar = new TableColumn<ClienteEntidad, Void>("Eliminar");
        */
        colId.setPrefWidth(120.0);
        colNombre.setPrefWidth(180.0);
        colPrimerApellido.setPrefWidth(210.0);
        colSegundoApellido.setPrefWidth(210.0);
        colTelefono.setPrefWidth(140.0);
        colTelefono2.setPrefWidth(140.0);
        //colDireccion_IDDireccion.setPrefWidth(100);
        //colDetalles.setPrefWidth(120.0);
        //colEliminar .setPrefWidth(120.0);

        colId.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, Integer>("idCliente"));
        colNombre.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("NombreCliente"));
        colPrimerApellido.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("PrimerApellido"));
        colSegundoApellido.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("SegundoApellido"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("Telefono"));
        colTelefono2.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("TelRecuperacion"));
        //colDireccion_IDDireccion.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("ID"));

        //colDetalles.setCellValueFactory(new PropertyValueFactory<ClienteEntidad, String>("Detalles"));

        //crear y accionar el boton de aliminar
        /*Callback<TableColumn<ClienteEntidad, Void>, TableCell<ClienteEntidad, Void>> cellFactory1 = new Callback<TableColumn<ClienteEntidad, Void>, TableCell<ClienteEntidad, Void>>() {
            public TableCell<ClienteEntidad, Void> call(TableColumn<ClienteEntidad, Void> param) {
                TableCell<ClienteEntidad, Void> cell1 = new TableCell<ClienteEntidad, Void>() {
                    final Button boton = new Button("Eliminar");

                    {
                        this.boton.setOnAction((evt) -> {
                            this.getTableView().getItems().remove(this.getIndex());
                        });
                        this.boton.setPrefWidth(80.0);
                        this.boton.setPrefHeight(10.0);
                    }

                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            this.setGraphic((Node)null);
                        } else {
                            this.setGraphic(this.boton);
                        }
                    }
                };
                return cell1;
            }
        };
        colEliminar.setCellFactory(cellFactory1);*/
        //Agrega las columnas a la tabla
        this.tablaClientes.getColumns().addAll(colId, colNombre, colPrimerApellido, colSegundoApellido, colTelefono, colTelefono2);
        //this.tablaClientes.getColumns().add(colEliminar);

    }

    public void agregarCliente(ClienteEntidad cliente, int seleccion){
        clientes.remove(seleccion);
        clientes.add(seleccion, cliente);
        tablaClientes.refresh();
    }

    public void eliminarCliente(int seleccion){
        clientes.remove(seleccion);
        tablaClientes.refresh();
    }

    public TableView<ClienteEntidad> getTablaClientes() {
        return this.tablaClientes;
    }

    public ObservableList<ClienteEntidad> getListaClientes() {
        return this.clientes;}

    public void agregarClientes(List<ClienteEntidad> listaClientes){
        clientes.addAll(listaClientes);
    }

    public void limpiarLista(){this.clientes.clear();}
}
