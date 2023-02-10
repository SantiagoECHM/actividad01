package com.pasteleria.gui.Trabajador;

import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.MOD.TrabajadorEntidad;
import com.pasteleria.gui.VentanaWaring;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.List;

public class TablaTrabajador {
    private TableView<TrabajadorEntidad> tablaUsuarios;
        private ObservableList<TrabajadorEntidad> trabajadors = FXCollections.observableArrayList();

        public TablaTrabajador(List<TrabajadorEntidad> listaTrabajador) {
            this.trabajadors.addAll(listaTrabajador);
            this.tablaUsuarios = new TableView<>();
            this.tablaUsuarios.getStyleClass().add("table-cell");
            this.tablaUsuarios.setPrefWidth(700.0);
            this.crearTabla();
        }
        //crear la tabla con los atributos del usuario

        public void crearTabla() {
            this.tablaUsuarios.setItems(this.trabajadors);
            TableColumn<TrabajadorEntidad, Integer> colId = new TableColumn<TrabajadorEntidad, Integer>("ID");
            TableColumn<TrabajadorEntidad, String> colNombre = new TableColumn<TrabajadorEntidad, String>("Nombre");
            TableColumn<TrabajadorEntidad, String> colTelefono = new TableColumn<TrabajadorEntidad, String>("telefono");
            TableColumn<TrabajadorEntidad, String> colCont = new TableColumn<TrabajadorEntidad, String>("pass");
            TableColumn<TrabajadorEntidad, String> colTipo = new TableColumn<TrabajadorEntidad, String>("tipo");

            colNombre.setPrefWidth(120.0);
            colTelefono.setPrefWidth(120.0);
            colCont.setPrefWidth(120.0);
            colTipo.setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<TrabajadorEntidad, Integer>("idTrabajador"));
            colNombre.setCellValueFactory(new PropertyValueFactory<TrabajadorEntidad, String>("Nombre"));
            colTelefono.setCellValueFactory(new PropertyValueFactory<TrabajadorEntidad, String>("Telefono"));
            colCont.setCellValueFactory(new PropertyValueFactory<TrabajadorEntidad, String>("Pass"));
            colTipo.setCellValueFactory(new PropertyValueFactory<TrabajadorEntidad, String>("Tipo"));

//            colEliminar.setCellFactory(cellFactory1);
            this.tablaUsuarios.getColumns().addAll(colId, colNombre, colTelefono, colCont, colTipo);
        }
        //Metodos de la tabla
        public void agregarTrabajador(TrabajadorEntidad pastel, int seleccion) {
            this.trabajadors.remove(seleccion);
            this.trabajadors.add(seleccion, pastel);
            tablaUsuarios.refresh();
        }

    public void agregarTrabajador(TrabajadorEntidad pastel) {
        this.trabajadors.add(pastel);
        tablaUsuarios.refresh();
    }

        public TableView<TrabajadorEntidad> getTablaUsuario() {
            return this.tablaUsuarios;
        }

        public ObservableList<TrabajadorEntidad> getListaTrabajadores(){
            return this.trabajadors;
         }

         public void eliminarTrabajador(int seleccion){
            trabajadors.remove(seleccion);
            tablaUsuarios.refresh();
         }

    public void agregarTrabajadores(List<TrabajadorEntidad> listaTrabajadores) {
        this.trabajadors.addAll(listaTrabajadores);
    }

    public void limpiarLista() {
        this.trabajadors.clear();
    }

    }
