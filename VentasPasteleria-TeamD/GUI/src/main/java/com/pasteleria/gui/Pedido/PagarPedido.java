package com.pasteleria.gui.Pedido;


import com.pasteleria.CONT.*;
import com.pasteleria.MOD.*;
import com.pasteleria.gui.VentanaExito;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;


public class PagarPedido extends GridPane {
    private Label lTotal;
    private Label lDineroDado;
    private Label lCambio;
    private TextField dineroDado;
    private Button bCancelar;
    private Button bAceptar;
    private DireccionEntidad direccionEntidad;
    private VentaEntidad ventaEntidad;
    private ClienteEntidad clienteEntidad;
    private Integer total;
    private List<PastelEntidad> listaPasteles;
    public PagarPedido(Stage stage, int total, DireccionEntidad direccionEntidad, VentaEntidad ventaEntidad, ClienteEntidad clienteEntidad, List<PastelEntidad> listaPasteles){
        this.direccionEntidad=direccionEntidad;
        this.clienteEntidad=clienteEntidad;
        this.ventaEntidad=ventaEntidad;
        this.total=total;
        this.listaPasteles=listaPasteles;
        setStyle("-fx-background-color: #ecf0f1");
        bAceptar = new Button("Aceptar");
        bAceptar.getStyleClass().addAll("BotonAceptar");
        bAceptar.setOnAction(e -> {
            System.out.println("Aceptar");
            //btnGraficos.setOnAction(evt -> {mostrarVenataGraficos();});
            stage.close();

        });

        bCancelar = new Button("Cancelar");
        bCancelar.getStyleClass().add("BotonCancelar");
        bCancelar.setOnAction(e -> {
            System.out.println("Cancelar");
            stage.close();
        });

        lTotal = new Label("Total: $"+total);
        lDineroDado = new Label("Anticipo: ");
        lCambio = new Label("Restante: $");

        dineroDado=new TextField();
        dineroDado.setPromptText("Dinero de anticipo");
        dineroDado.getStyleClass().add("ios-field");
        dineroDado.setPrefWidth(190);

        bAceptar.setOnAction(evt->{
            if(comprobarDinero(dineroDado.getText())){
                crearPedido();
                stage.close();
            }
        });

        dineroDado.textProperty().addListener(observable->{
            Integer cambio=  total-getDineroDato();
            lCambio.setText("Restante: $"+cambio);
        } );

        add(lTotal, 1, 1, 2, 1);
        add(lDineroDado,1,3);
        add(dineroDado,2,3);
        add(lCambio, 1,4,2,1);
        add(bCancelar,1,5);
        add(bAceptar,2,5);
        setHgap(20);
        setVgap(20);
    }

    private void crearPedido() {
        //Dar de alta la direccion
        new DireccionesController().AgregarDireccion(direccionEntidad);
        //Encontrar el id que se le asigno
        List<Integer> listaDirecciones = new DireccionesController().CrearListaID();
        int idDireccion = listaDirecciones.get(listaDirecciones.size()-1);
        //Se completa el cliente entidad dandole id de la direccion
        clienteEntidad.setDireccionIdDireccion(idDireccion);
        //Dar de alta el cliente
        new ClientesController().AgregarCliente(clienteEntidad);
        //Acompletar la venta
        ventaEntidad.setClienteByClienteIdCliente(clienteEntidad);
        ventaEntidad.setTotal(total);
        ventaEntidad.setAnticipo(getDineroDato());
        new VentasController().Agregar(ventaEntidad);
        //Agarrar id de la venta
        List<Integer> listaVenta = new VentasController().CrearListaID();
        int idVenta = listaVenta.get(listaVenta.size()-1);
        //Agregar pasteles
        for (PastelEntidad pastel : listaPasteles) {
            pastel.setEstadoPastel("pendiente");
            pastel.setEstilo("pedido");
            new PastelesController().Agregar(pastel);
            List<Integer> listaDB = new PastelesController().CrearListaID();
            int idPastel = listaDB.get(listaDB.size() - 1);
            new PastelVentaController().Agregar(new TieneEntidad("pendiente", 1, idPastel, idVenta));
        }
        VentanaExito ventanaExito = new VentanaExito("Venta levantada con exitosamente", "success");
    }

    private boolean comprobarDinero(String dinero) {
        if(!dinero.isEmpty()) {
            char[] array = dinero.toCharArray();
            for (char letra : array) {
                if (!Character.isDigit(letra)) {
                    Alert alertasalir = new Alert(Alert.AlertType.ERROR);
                    alertasalir.setTitle("Error");
                    alertasalir.setContentText("Valor no valido, solo se aceptan numeros");
                    alertasalir.show();
                    alertasalir.setHeight(300);
                    alertasalir.setWidth(300);
                    return false;
                }
            }
        }else {
            Alert alertasalir = new Alert(Alert.AlertType.ERROR);
            alertasalir.setTitle("Error");
            alertasalir.setContentText("Campo vacio, ingresa un valor");
            alertasalir.show();
            alertasalir.setHeight(300);
            alertasalir.setWidth(300);
            return false;
        }
        return true;
    }

    private int getDineroDato() {
        return Integer.parseInt(dineroDado.getText());
    }
}
