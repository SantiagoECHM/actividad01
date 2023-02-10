package com.pasteleria.gui.Pastel;

import com.pasteleria.MOD.PastelEntidad;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EditarPastel extends GridPane {
    private float precioPastel=0;
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
    private ImageView imagenesPastel;
    private Stage stage1;
    private Button bModificar;
    private PastelEntidad pastel;

    public EditarPastel(Stage stage, PastelEntidad pastel, TablaPastelesEditar tablaPasteles, int seleccion){
        this.pastel=pastel;
        this.stage1=stage;
        bModificar=new Button("Modificar");
        inicializarComponentes(bModificar);
        llenarFormulario(pastel);
        precioPastel=pastel.getPrecio();
        bModificar.setOnAction(evtm->{
            PastelEntidad pastel1=crearPastel();
            tablaPasteles.agregarPastel(pastel1, seleccion);
            stage.close();
        });

    }

    private void llenarFormulario(PastelEntidad pastel) {
        cbTamano.getSelectionModel().select(pastel.getSize());
        cbRelleno.getSelectionModel().select(pastel.getRelleno());
        cbForma.getSelectionModel().select(pastel.getForma());
        cbNoPisos.getSelectionModel().select(pastel.getNumPisos()-1);
        cbTipoPan.getSelectionModel().select(pastel.getTipoPan());
        tDetalles.setText(pastel.getDescripccion());
        color.setValue(Color.web(pastel.getColor()));
        inicializarPrecios();
        Precio.setText("Precio: "+pastel.getPrecio());
    }

    private void inicializarPrecios() {
        int seleccion1=cbTamano.getSelectionModel().getSelectedIndex();
        if(seleccion1==0){
            precioTamano=110;
        }
        if(seleccion1==1){
            precioTamano=120;
        }
        if(seleccion1==2){
            precioTamano=150;
        }
        int seleccion2=cbTipoPan.getSelectionModel().getSelectedIndex();
        if(seleccion2==0){
            precioTipoPan=100;
        }
        if(seleccion2==1){
            precioTipoPan=120;
        }
        if(seleccion2==2){
            precioTipoPan=150;
        }
        int seleccion3=cbRelleno.getSelectionModel().getSelectedIndex();
        if(seleccion3==0){
            precioRelleno=80;
        }
        if(seleccion3==1){
            precioRelleno=50;
        }
        if(seleccion3==2){
            precioRelleno=30;
        }
        int seleccion4=cbNoPisos.getSelectionModel().getSelectedIndex();
        if(seleccion4==0){
            precioRNoPisos=100;
        }
        if(seleccion4==1){
            precioRNoPisos=150;
        }
        if(seleccion4==2){
            precioRNoPisos=310;
        }
        if(seleccion4==3){
            precioRNoPisos=450;
        }
        if(seleccion4==4){
            precioRNoPisos=600;
        }
    }

    private void inicializarComponentes(Button bModificar) {
        this.setStyle("-fx-background-color: #dfe6e9");
        lTipo=new Label("Tipo de Pan: ");
        cbTipoPan=new ComboBox();
        crearListaTipoPan(cbTipoPan);
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
        crearListaRelleno(cbRelleno);
        cbRelleno.setOnAction(evt->{
            accionCBRelleno();
        });

        lNoPisos=new Label("Numero de pisos: ");
        cbNoPisos=new ComboBox();
        cbNoPisos.setPrefHeight(35);
        cbNoPisos.setPrefWidth(200);
        crearListaNoPisos(cbNoPisos);
        cbNoPisos.setOnAction(evt->{
            accionCBNoPisos();
        });



        lForma = new Label("Forma del pastel: ");
        cbForma=new ComboBox();
        cbForma.setPrefHeight(35);
        cbForma.setPrefWidth(200);
        crearListaFromas(cbForma);

        lTamano=new Label("Selecciona el tamaño: ");
        cbTamano=new ComboBox();
        cbTamano.setPrefWidth(200);
        crearListaTamanos(cbTamano);
        cbTamano.setOnAction(evt->{
            accionCBTamano();
        });

        lDetalles=new Label("Detalles del pastel: ");
        tDetalles=new TextArea();
        tDetalles.setMaxSize(300,70);
        tDetalles.setPromptText("Ingresa los detalles del pastel");
        tDetalles.getStyleClass().add("ios-field");

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
        this.add(Precio,3,15);
        this.add(bModificar,4,15);
        bModificar.getStyleClass().add("cssBoton");
        bModificar.setAlignment(Pos.BOTTOM_LEFT);


        setHgap(7);
        setVgap(7);
        setAlignment(Pos.CENTER);
    }

    private void accionCBTamano() {
        int seleccion=cbTamano.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioTamano=110;
        }
        if(seleccion==1){
            precioTamano=120;
        }
        if(seleccion==2){
            precioTamano=150;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos+precioTamano;
        Precio.setText("Precio del pastel: $"+precioPastel);
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

    private void crearListaNoPisos(ComboBox<Integer> cbNoPisos) {
        cbNoPisos.getItems().addAll(1,2,3,4,5);
    }

    private void crearListaRelleno(ComboBox<String> cbRelleno) {
        cbRelleno.getItems().addAll("Queso Crema","Frutas","Fresa");
    }

    private void crearListaFromas(ComboBox imagenesForma) {
        String []nombreTamanos = {"circulo.png","cuadrado.png"};
        ImageView []imagenes = new ImageView[nombreTamanos.length];

        int i=0;
        for(String nombreTamano : nombreTamanos) {
            Image inombreTamano = new Image(getClass().getResourceAsStream(nombreTamano));
            imagenes[i] = new ImageView(inombreTamano);
            imagenes[i].setFitHeight(25);
            imagenes[i].setFitWidth(25);
            i++;
        }
        imagenesForma.getItems().addAll(imagenes);
        imagenesForma.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    private Rectangle rectangulo; {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangulo = new Rectangle(25, 25);
                    }
                    @Override
                    public void updateItem(ImageView item, boolean vacio) {
                        super.updateItem(item, vacio);
                        if (item == null || vacio)
                            setGraphic(null);
                        else {
                            rectangulo.setFill(new ImagePattern(item.getImage()));
                            setGraphic(rectangulo);
                        }
                    }
                };
            }
        });
    }

    private void crearListaTipoPan(ComboBox<String> cbTipoPan) {
        cbTipoPan.getItems().addAll("Chocolate","3 Leches","Moka");
    }

    private void crearListaTamanos(ComboBox<String> cbTamano) {
        cbTamano.getItems().addAll("Chico","Mediano","Grande");
    }

    public PastelEntidad crearPastel(){
        String forma;
        if(cbForma.getSelectionModel().getSelectedIndex()==0)
            forma="circulo";
        else
            forma="cuadrado";
        return null;
        //"1", cbTipoPan.getValue(), cbRelleno.getValue(), color.getValue().toString(), forma, cbNoPisos.getValue(), cbTamano.getValue(), precioPastel, tDetalles.getText()

    }
}
