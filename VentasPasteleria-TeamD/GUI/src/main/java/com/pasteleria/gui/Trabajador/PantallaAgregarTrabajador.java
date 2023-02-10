package com.pasteleria.gui.Trabajador;

import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.MOD.TrabajadorEntidad;
import com.pasteleria.gui.VentanaAlert;
import com.pasteleria.gui.VentanaWaring;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PantallaAgregarTrabajador extends GridPane {
    private Label etiNom;
    private Label etiPrimApe;
    private Label etiSegApe;
    private Label etiTel;
    private Label etiPass;
    private Label etiTipo;
    private TextField txtNom;
    private TextField txtPrimApe;
    private TextField txtSegApe;
    private TextField txtTel;
    private TextField txtPass;
    private ComboBox<String> cbTipo;
    private Button btnElim;
    private Button btnAdd;
    private ImageView imgEliminar;
    private ImageView imgConfirmar;
    private Stage stage;
    public PantallaAgregarTrabajador(Stage stage1, TablaTrabajador tablaHelper){
        this.stage=stage1;
        //agrega estilo a la ventana
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        imgEliminar = new ImageView("contenedor-de-basura.png");
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnElim = new Button();
        btnElim.setGraphic(imgEliminar);
        btnElim.setTooltip(new Tooltip("Eliminar usuario"));
        btnElim.getStyleClass().add("cssBoton");

        imgConfirmar = new ImageView("correcto.png");
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAdd = new Button();
        btnAdd.setShape(new Circle(1.0));
        btnAdd.setGraphic(imgConfirmar);
        btnAdd.setTooltip(new Tooltip("Agregar usuario"));

        btnAdd.setOnAction(evtm->{
            new TrabajadoresController().Agregar(new TrabajadorEntidad(crearTrabajador()));
            tablaHelper.limpiarLista();
            tablaHelper.agregarTrabajadores(new TrabajadoresController().ListarTodos());
            stage.close();
        });

        inicializarComponentes();
    }

    public PantallaAgregarTrabajador(Stage stage1, TrabajadorEntidad trabajador, int seleccion, TablaTrabajador tablaTrabajador){
        this.stage=stage1;
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        btnElim = new Button("Eliminar");

        btnElim.setOnAction((evt) -> {
            VentanaWaring ventanaWaring = new VentanaWaring("Estas seguro de borrar este trabajador", "Importante");
            if(ventanaWaring.resultado()){
                TrabajadoresController helper =new TrabajadoresController();
                helper.Eliminar(trabajador);
                tablaTrabajador.eliminarTrabajador(seleccion);
                stage.close();
            }

        });

        btnAdd = new Button("Modificar");

        btnAdd.setOnAction(evtm->{
            VentanaWaring ventanaWaring = new VentanaWaring("Desear guardar los cambios realizados?","Guardar Trabajador");
            if(ventanaWaring.resultado()){
                new TrabajadoresController().Modificar(crearTrabajadorEditar(trabajador));
                tablaTrabajador.agregarTrabajador(crearTrabajadorEditar(trabajador), seleccion);
                stage.close();
            }
        });

        inicializarComponentes();

        llenarComponenetes(trabajador);
    }

    private TrabajadorEntidad crearTrabajadorEditar(TrabajadorEntidad trabajador) {
        if(comprobar()){
            return new TrabajadorEntidad(trabajador.getIdTrabajador(), txtNom.getText(), txtPrimApe.getText(), txtSegApe.getText(),txtTel.getText(), txtPass.getText(),cbTipo.getValue());
        }
        return null;
    }

    private void llenarComponenetes(TrabajadorEntidad trabajador) {
        txtNom.setText(trabajador.getNombre());
        txtPrimApe.setText(trabajador.getPrimerApellido());
        txtSegApe.setText(trabajador.getSegundoApellido());
        txtPass.setText(trabajador.getPass());
        txtTel.setText(trabajador.getTelefono());
        cbTipo.getSelectionModel().select(trabajador.getTipo());

    }

    private void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        etiNom = new Label("Nombre: ");
        txtNom = new TextField();

        etiPrimApe = new Label("Primer apellido: ");
        txtPrimApe = new TextField();

        etiSegApe = new Label("Segundo Apellido: ");
        txtSegApe = new TextField();

        etiPass = new Label("Contraseña: ");
        txtPass = new TextField();

        etiTel = new Label("Telefono: ");
        txtTel = new TextField();

        etiTipo = new Label("Tipo: ");
        cbTipo = new ComboBox<String>();

        llenarCBTipo();



        this.add(etiNom, 1,1);
        this.add(txtNom, 2, 1);

        this.add(etiPrimApe, 1,2);
        this.add(txtPrimApe, 2, 2);

        this.add(etiSegApe, 1,3);
        this.add(txtSegApe, 2, 3);

        this.add(etiPass,1,4);
        this.add(txtPass, 2, 4);

        this.add(etiTel, 1, 5);
        this.add(txtTel, 2, 5);

        this.add(etiTipo, 1, 6);
        this.add(cbTipo, 2, 6);

        this.add(btnElim, 1, 7);
        this.add(btnAdd, 3, 7);
    }

    private void llenarCBTipo() {

        cbTipo.getItems().addAll("Pastelero", "Ventas", "Repartidor", "Administrador");
    }

    private TrabajadorEntidad crearTrabajador() {
        if(comprobar()){
            return new TrabajadorEntidad(txtNom.getText(), txtPrimApe.getText(), txtSegApe.getText(),txtTel.getText(), txtPass.getText(),cbTipo.getValue());
        }
        return null;
    }



    private boolean comprobar() {
        String errores="";
        if(txtNom.getText().isEmpty()){
            errores+="No se agrego un nombre\r\n";
        }
        if(txtSegApe.getText().isEmpty()) {
            errores += "No se agrego el segundo apellido\r\n";
        }
        if(txtPrimApe.getText().isEmpty()){
            errores+="No se agrego el primer apellido\r\n";
        }
        if(txtTel.getText().isEmpty()){
            errores+="No se agrego un telefono\r\n";
        }
        if(cbTipo.getSelectionModel().isEmpty()){
            errores+="No se agrego un tipo de trabajador\r\n";
        }
        if(txtPass.getText().isEmpty()){
            errores+="No se agrego una contrasenia\r\n";
        }
        if(errores.equals("")){
            return true;
        }else {
            VentanaAlert alerta = new VentanaAlert(errores, "Error el agregar trabajdor");
            return false;
        }
    }
}
