package com.pasteleria.gui.Pastel;

import com.pasteleria.CONT.PastelesController;
import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.gui.VentanaAlert;
import com.pasteleria.gui.VentanaWaring;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AgregarPastel extends GridPane {
    private Integer precioPastel=0;
    private Integer precioTamano=0;
    private Integer precioTipoPan=0;
    private Integer precioForma=0;
    private Integer precioRelleno=0;
    private Integer precioRNoPisos=0;
    private ComboBox<String> cbTamano;
    private ComboBox<String>  cbRelleno;
    private ComboBox<String> cbTipoPan;
    private ComboBox<String> cbForma;
    private ComboBox<Integer> cbNoPisos;
    private ComboBox<Integer> cbCantidad;
    private ColorPicker color;
    private TextArea tDetalles;
    private Label Precio;
    private Label lAgregar;
    private Label lTamano;
    private Label lRelleno;
    private Label lTipo;
    private Label lColor;
    private Label lForma;
    private Label lDetalles;
    private Label lNoPisos;
    private Label lCantidad;
    private ImageView imagenesPastel;
    private Stage stage1;
    private Button bAgregar;
    private Button bCancelar;
    private PastelEntidad pastel;
    public AgregarPastel(Stage stage, TablaPasteles tablaPasteles){
        this.stage1=stage;
        bAgregar=new Button("Agregar");
        bAgregar.setOnAction(evtm->{
            if(comprobar()) {
                PastelEntidad pastel=crearPastel();
                new PastelesController().Agregar(pastel);
                tablaPasteles.agregarPastel(pastel);
                stage.close();
            }
        });

        bCancelar= new Button("Cancelar");
        bCancelar.setOnAction(evtm->{
            VentanaWaring alerta = new VentanaWaring("estas seguro de cerrar la ventana?","Espera");
            if(alerta.resultado()){
                stage.close();
            }
        });
        inicializarComponentes();
    }



    private boolean comprobar() {
        String errores="";
        if(cbTamano.getSelectionModel().isEmpty()){
            errores+="No se selecciono un tamanio\r\n";
        }
        if(cbRelleno.getSelectionModel().isEmpty()){
            errores+="No se selecciono un relleno\r\n";
        }
        if(cbTipoPan.getSelectionModel().isEmpty()){
            errores+="No se selecciono un tipo de pan\r\n";
        }
        if(cbForma.getSelectionModel().isEmpty()){
            errores+="No se selecciono una forma\r\n";
        }
        if(cbNoPisos.getSelectionModel().isEmpty()){
            errores+="No se selecciono el numero de pisos\r\n";
        }
        if(cbCantidad.getSelectionModel().isEmpty()){
            errores+="No se selecciono la cantidad\r\n";
        }
        if(color.getValue().equals(null)){
            errores+="No se selecciono un color\r\n";
        }
        if(tDetalles.getText().isEmpty()){
            errores+="No se escribieron los detalles\r\n";
        }

        if(errores.equals("")){
            return true;
        }else{
            VentanaAlert alert = new VentanaAlert(errores, "Error al agregar el pastel");
            return false;
        }
    }

    public AgregarPastel(Stage stage,int seleccion, PastelEntidad pastelSeleccionado, TablaPasteles tablaPasteles){
        this.stage1=stage;
        this.pastel=pastelSeleccionado;
        bAgregar=new Button("Modificar");
        bAgregar.setOnAction(evtm->{
            VentanaWaring ventanaWaring = new VentanaWaring("presiona ok para aceptar", "Estas seguro de guardar los cambios?");
                if(ventanaWaring.resultado()) {
                    PastelEntidad pastel = crearPastelModificar();
                    new PastelesController().Modificar(pastel);
                    tablaPasteles.agregarPastel(pastel, seleccion);
                    stage.close();
                }
        });
        bCancelar = new Button("Eliminar");
        bCancelar.setOnAction(evtm->{
            VentanaWaring alerta = new VentanaWaring("Todos los registros relacionados con el pastel se eliminaran","estas seguro de eliminar este pastel?");
            if(alerta.resultado()) {
                new PastelesController().Eliminar(pastel);
                tablaPasteles.eliminarPastel(pastel);
                stage.close();
            }
        });
        inicializarComponentes();
        llenarComponentes();
    }

    private void llenarComponentes() {
        cbTamano.getSelectionModel().select(pastel.getSize());
        cbRelleno.getSelectionModel().select(pastel.getRelleno());
        cbTipoPan.getSelectionModel().select(pastel.getTipoPan());
        cbForma.getSelectionModel().select(pastel.getForma());
        cbNoPisos.getSelectionModel().select(pastel.getNumPisos());
        cbCantidad.getSelectionModel().select((pastel.getCantidad()-1));
        color.setValue(Color.web(pastel.getColor()));
        tDetalles.setText(pastel.getDescripccion());
        Precio.setText("Precio del pastel: $"+pastel.getPrecio());
    }

    public AgregarPastel(Stage stage, TablaPasteles tablaPasteles, Label total){
        this.stage1=stage;
        bAgregar=new Button("Agregar");
        bAgregar.setOnAction(evtm->{
            PastelEntidad pastel=crearPastel();
//            new PastelesController().Agregar(pastel);
            tablaPasteles.agregarPastel(pastel);
            total.setText("Total: $"+tablaPasteles.total());
            stage.close();
        });
        bCancelar=new Button("Cancelar");
        bCancelar.setOnAction(evtm->{
            VentanaWaring ventanaWaring = new VentanaWaring("Estas seguro se cacelar el pastel?", "Precaucion");
            if(ventanaWaring.resultado()){
                stage.close();
            }
        });
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.setStyle("-fx-background-color: #dfe6e9");
        lTipo=new Label("Tipo de Pan: ");
        cbTipoPan=new ComboBox();
        crearListaTipoPan();
        cbTipoPan.setPrefHeight(30);
        cbTipoPan.setPrefWidth(200);
        cbTipoPan.getStyleClass().add("combo-box-base");
        cbTipoPan.setOnAction(evt->{
            accionCBTipoPan();
        });

        lColor=new Label("Color del pastel:");
        color=new ColorPicker();
        color.setPrefHeight(39);
        color.setPrefWidth(200);

        lRelleno=new Label("Relleno del partel: ");
        cbRelleno=new ComboBox();
        cbRelleno.setPrefHeight(35);
        cbRelleno.setPrefWidth(200);
        crearListaRelleno();
        cbRelleno.setOnAction(evt->{
            accionCBRelleno();
        });

        lNoPisos=new Label("Numero de pisos: ");
        cbNoPisos=new ComboBox();
        cbNoPisos.setPrefHeight(35);
        cbNoPisos.setPrefWidth(200);
        crearListaNoPisos();
        cbNoPisos.setOnAction(evt->{
            accionCBNoPisos();
        });



        lForma = new Label("Forma del pastel: ");
        cbForma=new ComboBox();
        cbForma.setPrefHeight(35);
        cbForma.setPrefWidth(200);
        crearListaFromas();

        lTamano=new Label("Selecciona el tamaño: ");
        cbTamano=new ComboBox();
        cbTamano.setPrefWidth(200);
        crearListaTamanos();

        lDetalles=new Label("Detalles del pastel: ");
        tDetalles=new TextArea();
        tDetalles.setMaxSize(300,70);
        tDetalles.setPromptText("Ingresa los detalles del pastel");
        tDetalles.getStyleClass().add("ios-field");

        lCantidad=new Label("Cantidad: ");
        cbCantidad=new ComboBox();
        crearListaCantidad();
        cbCantidad.setPrefHeight(30);
        cbCantidad.setPrefWidth(200);
        cbCantidad.getStyleClass().add("combo-box-base");
        cbCantidad.setOnAction(evt->{
            accionCBTipoPan();
        });

        Precio=new Label("Precio del pastel: $"+precioPastel);

        //setPromptText
        this.add(lTipo,3,0);
        this.add(cbTipoPan,4,0);
        this.add(lColor,3,2);
        this.add(color,4,2);
        this.add(lRelleno,3,4);
        this.add(cbRelleno,4,4);
        this.add(lTamano,3,6);
        this.add(cbTamano,4,6);
        this.add(lForma,3,8);
        this.add(cbForma,4,8);
        this.add(lNoPisos,3,10);
        this.add(cbNoPisos,4,10);
        this.add(lDetalles,3,12);
        this.add(tDetalles,4,12);
        this.add(lCantidad,3,14);
        this.add(cbCantidad,4,14);
        this.add(Precio,3,17);
        this.add(new HBox(bAgregar, bCancelar),4,17);
        bAgregar.getStyleClass().add("cssBoton");
        bAgregar.setAlignment(Pos.BOTTOM_LEFT);


        setHgap(7);
        setVgap(7);
        setAlignment(Pos.CENTER);
    }

    private void crearListaCantidad() {
        cbCantidad.getItems().addAll(1,2,3,4,5);
        cbCantidad.getSelectionModel().select(0);
    }

    private void accionCBTipoPan() {
        int seleccion=cbTipoPan.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioTipoPan=100;
        }
        if(seleccion==1){
            precioTipoPan=120;
        }
        if(seleccion==2){
            precioTipoPan=150;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void accionCBRelleno() {
        int seleccion=cbRelleno.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioRelleno=80;
        }
        if(seleccion==1){
            precioRelleno=50;
        }
        if(seleccion==2){
            precioRelleno=30;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void accionCBNoPisos() {
        int seleccion=cbNoPisos.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioRNoPisos=100;
        }
        if(seleccion==1){
            precioRNoPisos=150;
        }
        if(seleccion==2){
            precioRNoPisos=310;
        }
        if(seleccion==3){
            precioRNoPisos=450;
        }
        if(seleccion==4){
            precioRNoPisos=600;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void crearListaNoPisos() {
        cbNoPisos.getItems().addAll(1,2,3,4,5);
    }

    private void crearListaRelleno() {
        cbRelleno.getItems().addAll("Queso Crema","Frutas","Fresa");
    }

    private void crearListaFromas() {
        cbForma.getItems().addAll("Cuadrado","Circular");
    }


    private void crearListaTipoPan() {
        cbTipoPan.getItems().addAll("Chocolate","3 Leches","Moka");
    }

    private void crearListaTamanos() {
        cbTamano.getItems().addAll("Chico","Mediano","Grande");
    }
    public PastelEntidad crearPastel(){
        return new PastelEntidad(color.getValue().toString(), cbForma.getValue(),cbTamano.getValue(), cbRelleno.getValue(),
                cbTipoPan.getValue(), cbNoPisos.getValue(), precioPastel, tDetalles.getText(), "disponible", "venta", cbCantidad.getValue());
    }

    public PastelEntidad crearPastelModificar(){
        return new PastelEntidad(pastel.getIdPastel(), color.getValue().toString(), cbForma.getValue(),cbTamano.getValue(), cbRelleno.getValue(),
                cbTipoPan.getValue(), cbNoPisos.getValue(), precioPastel, tDetalles.getText(), "disponible", "venta", cbCantidad.getValue());
    }
}
