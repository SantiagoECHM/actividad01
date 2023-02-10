package com.pasteleria.gui.Cliente;

import com.pasteleria.CONT.ClientesController;
import com.pasteleria.MOD.ClienteEntidad;
import com.pasteleria.gui.VentanaAlert;
import com.pasteleria.gui.VentanaWaring;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EditarCliente extends GridPane {

    private Button btnAceptar;
    private Button btnEliminar;

    private Label lNombre;
    private Label lApellidoP;
    private Label lApellidoM;
    private Label lTel1;
    private Label lTel2;

    private TextField tNombre;
    private TextField tApellidoP;
    private TextField tApellidoM;
    private TextField tTel1;
    private TextField tTel2;

    private ClienteEntidad cliente;

    private ImageView imgEliminar;
    private ImageView imgConfirmar;
    private Stage stage1;

    public EditarCliente(Stage stage, ClienteEntidad cliente, int seleccion, TablaCliente tablaCliente) {
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        this.stage1 = stage;

        imgEliminar = new ImageView("contenedor-de-basura.png");
        imgEliminar.setFitWidth(50);
        imgEliminar.setFitHeight(50);

        btnEliminar = new Button();
        btnEliminar.setGraphic(imgEliminar);
        btnEliminar.setTooltip(new Tooltip("Eliminar cliente"));
        btnEliminar.getStyleClass().add("cssBoton");

        imgConfirmar = new ImageView("correcto.png");
        imgConfirmar.setFitHeight(40);
        imgConfirmar.setFitWidth(40);

        btnAceptar = new Button();
        btnAceptar.setShape(new Circle(1.0));
        btnAceptar.setGraphic(imgConfirmar);
        btnAceptar.setTooltip(new Tooltip("Agregar usuario"));

        btnAceptar.setOnAction(evtm->{
            VentanaWaring ventanaWaring = new VentanaWaring("¿Desear guardar los cambios realizados?","Guardar Cliente");
            if(ventanaWaring.resultado()){
                new ClientesController().ModificarCliente(crearClienteEditar(cliente));
                tablaCliente.agregarCliente(crearClienteEditar(cliente), seleccion);
                stage.close();
            }else{
                new ClientesController().ModificarCliente(crearClienteEditar(cliente));
                tablaCliente.agregarCliente(crearClienteEditar(cliente), seleccion);
                stage.close();
            }
        });

        btnEliminar.setOnAction(evtm->{
            VentanaWaring ventanaWaring = new VentanaWaring("Estas seguro de borrar este trabajador", "Importante");
            if(ventanaWaring.resultado()){
                ClientesController helper =new ClientesController();
                helper.EliminarCliente(cliente);
                tablaCliente.eliminarCliente(seleccion);
                stage.close();
            }else{
                ClientesController helper =new ClientesController();
                helper.EliminarCliente(cliente);
                tablaCliente.eliminarCliente(seleccion);
                stage.close();
            }
        });

        inicializarComponentes();
        llenarComponenetes(cliente);

    }

    private ClienteEntidad crearClienteEditar(ClienteEntidad cliente){
        if(comprobar()){
            return new ClienteEntidad(cliente.getIdCliente(), tNombre.getText(), tApellidoP.getText(), tApellidoM.getText(), tTel1.getText(), tTel2.getText(), cliente.getDireccionIdDireccion());
        }
        return null;
    }

    private ClienteEntidad eliminarClienteEditar(ClienteEntidad cliente){
        return null;
    }

    private void llenarComponenetes(ClienteEntidad cliente) {
        tNombre.setText(cliente.getNombreCliente());
        tApellidoP.setText(cliente.getPrimerApellido());
        tApellidoM.setText(cliente.getSegundoApellido());
        tTel1.setText(cliente.getTelefono());
        tTel2.setText(cliente.getTelRecuperacion());
    }

    public void inicializarComponentes(){
        this.setVgap(30);
        this.setHgap(10);
        this.setAlignment(Pos.TOP_CENTER);

        lNombre = new Label("Nombre: ");
        //lNombre.getStyleClass().add("label");
        tNombre = new TextField();

        lApellidoP = new Label("Apellido Paterno: ");
        tApellidoP = new TextField();

        lApellidoM = new Label("Apellido Materno: ");
        tApellidoM = new TextField();

        lTel1 = new Label("Teléfono: ");
        tTel1 = new TextField();

        lTel2 = new Label("Teléfono de Recuperación: ");
        tTel2 = new TextField();

        this.add(lNombre, 1,1);
        this.add(tNombre, 2, 1);

        this.add(lApellidoP, 1,2);
        this.add(tApellidoP, 2, 2);

        this.add(lApellidoM, 1,3);
        this.add(tApellidoM, 2, 3);

        this.add(lTel1,1,4);
        this.add(tTel1, 2, 4);

        this.add(lTel2, 1, 5);
        this.add(tTel2, 2, 5);

        this.add(btnEliminar, 1, 7);
        this.add(btnAceptar, 3, 7);
    }
    private boolean comprobar() {
        String errores="";
        if(tNombre.getText().isEmpty()){
            errores+="No se agregó nombre\r\n";
        }
        if(tApellidoP.getText().isEmpty()) {
            errores += "No se agregó apellido paterno\r\n";
        }
        if(tApellidoM.getText().isEmpty()){
            errores+="No se agregó apellido materno\r\n";
        }
        if(tTel1.getText().isEmpty()){
            errores+="No se agregó teléfono\r\n";
        }
        if(tTel2.getText().isEmpty()){
            errores+="No se agregó teléfono de respaldo\r\n";
        }
        if(errores.equals("")){
            return true;
        }else {
            VentanaAlert alerta = new VentanaAlert(errores, "Error el agregar trabajdor");
            return false;
        }
    }
}
