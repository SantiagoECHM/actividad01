package com.pasteleria.gui.Venta;


import com.pasteleria.CONT.PastelVentaController;
import com.pasteleria.CONT.PastelesController;
import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.CONT.VentasController;
import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.MOD.TieneEntidad;
import com.pasteleria.MOD.VentaEntidad;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;


public class PagarVenta extends GridPane {
    private Label lTotal;
    private Label lDineroDado;
    private Label lCambio;
    private TextField dineroDado;
    private Button bCancelar;
    private Button bAceptar;
    private Integer total;
    private int idTrabajador;
    private List<PastelEntidad> listaPastelesAgregados;
    private List<PastelEntidad> listaPastelesInventario;
    public PagarVenta(Stage stage, Integer total, Integer idTrabajador, List<PastelEntidad> listaPasteles, List<PastelEntidad> listaPasteles1){
        this.listaPastelesAgregados=listaPasteles;
        this.listaPastelesInventario=listaPasteles1;
        this.idTrabajador=idTrabajador;
        this.total=total;
        setStyle("-fx-background-color: #ecf0f1");

        bAceptar = new Button("Aceptar");
        bAceptar.getStyleClass().addAll("BotonAceptar");
        bAceptar.setOnAction(e -> {
            System.out.println("Aceptar");
            //btnGraficos.setOnAction(evt -> {mostrarVenataGraficos();});
            stage.close();

        });

        lTotal = new Label("Total: $"+total);
        lDineroDado = new Label("Dinero dado: ");
        lCambio = new Label("Cambio: $");

        dineroDado=new TextField();
        dineroDado.setPromptText("Dinero dado");
        dineroDado.getStyleClass().add("ios-field");
        dineroDado.setPrefWidth(150);

        dineroDado.textProperty().addListener(observable->{
            Integer cambio=  getDineroDato()-total;
            lCambio.setText("Cambio: $"+cambio);
        } );

        bCancelar = new Button("Cancelar");
        bCancelar.getStyleClass().add("BotonCancelar");
        bCancelar.setOnAction(e -> {
            System.out.println("Cancelar");
            stage.close();
        });





        bAceptar.setOnAction(evt->{
            if(comprobarDinero(dineroDado.getText())){
                realizarVenta();
                stage.close();
            }
        });
//        dineroDado.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if (keyEvent.getCode() == KeyCode.ENTER) {
//                    if (comprobarDinero(dineroDado.getText())) {
//                        double cambio = getDineroDato() - total;
//                        lCambio.setText("Cambio: $" + cambio);
//                    }
//                }
//
//            }
//
//
//        });
        add(lTotal, 1, 1, 2, 1);
        add(lDineroDado,1,3);
        add(dineroDado,2,3);
        add(lCambio, 1,4,2,1);
        add(bCancelar,1,5);
        add(bAceptar,2,5);
        setHgap(20);
        setVgap(20);
    }

    private void realizarVenta() {
        new VentasController().Agregar(new VentaEntidad("Directa", crearHoraActual(), crearFechaActual(),
                total, new TrabajadoresController().BuscarID(idTrabajador)));

        List<VentaEntidad> listaID = new VentasController().ListarTodasPorID();
        int idVenta;
        if(listaID.size()==0){
            idVenta=0;
        }else {
            idVenta = listaID.get(listaID.size() - 1).getIdVenta();
        }
        for(int i=0; i<listaPastelesAgregados.size(); i++){
            new PastelVentaController().Agregar(new TieneEntidad("Pagado",listaPastelesAgregados.get(i).getCantidad(), listaPastelesAgregados.get(i).getIdPastel(), idVenta));
            listaPastelesAgregados.get(i).setCantidad(getCantidadDelOriginal(listaPastelesAgregados.get(i)));
            new PastelesController().Modificar(listaPastelesAgregados.get(i));
        }
    }

    private int getCantidadDelOriginal(PastelEntidad pastel) {
        for(int i=0; i < listaPastelesInventario.size()-1;i++){
            if(pastel.getIdPastel()==listaPastelesInventario.get(i).getIdPastel()){
                return listaPastelesInventario.get(i).getCantidad();
            }
        }
        return 0;
    }

    private Date crearFechaActual() {
        LocalDateTime ahora= LocalDateTime.now();
        int anio = ahora.getYear();
        int mes = ahora.getMonthValue();
        int dia = ahora.getDayOfMonth();
        return new Date(anio, mes, dia);
    }

    private Time crearHoraActual() {
        LocalDateTime ahora= LocalDateTime.now();
        int hora = ahora.getHour();
        int minutos = ahora.getMinute();
        int segundos = ahora.getSecond();
        return new Time(hora, minutos, segundos);
    }

    private int getDineroDato() {
        return Integer.parseInt(dineroDado.getText());
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
}