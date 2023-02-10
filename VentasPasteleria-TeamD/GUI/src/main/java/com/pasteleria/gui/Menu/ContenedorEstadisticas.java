package com.pasteleria.gui.Menu;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;

public class ContenedorEstadisticas extends BorderPane {
    private boolean compactado = true;
    private ToolBar menuHamburguesa;
    private  Label titulo;
    public ContenedorEstadisticas(){
        menuHamburguesa = new ToolBar();
        setStyle("-fx-background-color: #dfe6e9");
        menuHamburguesa.setStyle("-fx-background-color: #0984e3");
        Background fondo = new Background(new BackgroundFill(Color.valueOf("#7AAAEC"),new CornerRadii(1),new Insets(1)));
        Background fondo2 = new Background(new BackgroundFill(Color.web("#3498db"),new CornerRadii(1),new Insets(1)));
        URL rGrafica = getClass().getResource("fondoGrafica.jpg");
        ImageView fondoGrafica = new ImageView(new Image(rGrafica.toExternalForm()));
        URL rMenu = getClass().getResource("lines.png");
        ImageView iconoMenu = new ImageView(new Image(rMenu.toExternalForm()));
        URL rimagenSale = getClass().getResource("Sale.png");
        ImageView icono1 = new ImageView(new Image(rimagenSale.toExternalForm()));
        URL rimagenCorte = getClass().getResource("CorteCaja.png");
        ImageView icono2 = new ImageView(new Image(rimagenSale.toExternalForm()));
        ImageView icono3 = new ImageView(new Image(rimagenCorte.toExternalForm()));

        Button botonHam = new Button();
        botonHam.setGraphic(iconoMenu);

        iconoMenu.setFitHeight(30);
        iconoMenu.setFitWidth(30);
        icono1.setFitHeight(30);
        icono1.setFitWidth(30);
        icono2.setFitHeight(30);
        icono2.setFitWidth(30);
        icono3.setFitHeight(30);
        icono3.setFitWidth(30);

        menuHamburguesa.setOrientation(Orientation.VERTICAL);
        Button opcion1=new Button("Ventas año");
        Button opcion2=new Button("Ventas semana");
        Button opcion3=new Button("Corte de caja");

        opcion1.setMinWidth(152);
        opcion2.setMinWidth(152);
        opcion3.setMinWidth(152);

        String estilo="-fx-text-fill: black;-fx-font-size: 12pt";
        opcion1.setGraphic(icono1);
        opcion1.setAlignment(Pos.CENTER_LEFT);
        opcion1.setGraphicTextGap(30);
        opcion1.setBackground(fondo);
        opcion1.setStyle(estilo);

        opcion1.setOnMouseEntered(evt->{
            opcion1.setBackground(fondo2);
        });
        fondoGrafica.setFitHeight(450);
        fondoGrafica.setFitWidth(500);
        menuHamburguesa.setMaxWidth(186);
        menuHamburguesa.setMinWidth(64);
        menuHamburguesa.setPrefWidth(65);
        botonHam.setPrefWidth(52);
        opcion1.setPrefWidth(52);
        opcion1.setMaxWidth(178);
        opcion1.setMinWidth(51);
        opcion2.setPrefWidth(52);
        opcion2.setMaxWidth(178);
        opcion2.setMinWidth(51);
        opcion3.setPrefWidth(52);
        opcion3.setMaxWidth(178);
        opcion3.setMinWidth(51);

        botonHam.setOnAction(evt->{
            if(!compactado){
                Duration duracion = Duration.millis(500);
                Timeline tiempoMenu = new Timeline(new KeyFrame(duracion,new KeyValue(menuHamburguesa.minWidthProperty(), 65, Interpolator.EASE_BOTH)));
                Timeline tiempoVenta1 = new Timeline(new KeyFrame(duracion,new KeyValue(opcion1.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                Timeline tiempoVenta2 = new Timeline(new KeyFrame(duracion,new KeyValue(opcion2.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                Timeline tiempoCorte = new Timeline(new KeyFrame(duracion,new KeyValue(opcion3.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                tiempoVenta1.play();
                tiempoVenta2.play();
                tiempoCorte.play();
                tiempoMenu.play();
            }else{
                Duration duracion = Duration.millis(500);
                Timeline tiempoMenu = new Timeline(new KeyFrame(duracion,new KeyValue(menuHamburguesa.minWidthProperty(), 185, Interpolator.EASE_BOTH)));
                Timeline tiempoVenta1 = new Timeline(new KeyFrame(duracion,new KeyValue(opcion1.minWidthProperty(), 175, Interpolator.EASE_BOTH)));
                Timeline tiempoVenta2 = new Timeline(new KeyFrame(duracion,new KeyValue(opcion2.minWidthProperty(), 175, Interpolator.EASE_BOTH)));
                Timeline tiempoCorte = new Timeline(new KeyFrame(duracion,new KeyValue(opcion3.minWidthProperty(), 175, Interpolator.EASE_BOTH)));
                tiempoVenta1.play();
                tiempoVenta2.play();
                tiempoCorte.play();
                tiempoMenu.play();
            }
            compactado = !compactado;
        });

        botonHam.setOnMouseEntered(evt->{
            botonHam.setBackground(fondo2);
        });

        opcion1.setOnMouseEntered(evt->{
            opcion1.setBackground(fondo2);
        });

        opcion2.setOnMouseEntered(evt->{
            opcion2.setBackground(fondo2);
        });

        opcion3.setOnMouseEntered(evt->{
            opcion3.setBackground(fondo2);
        });

        botonHam.setOnMouseExited(evt->{
            botonHam.setBackground(fondo);
        });

        opcion1.setOnMouseExited(evt->{
            opcion1.setBackground(fondo);
        });

        opcion2.setOnMouseExited(evt->{
            opcion2.setBackground(fondo);
        });

        opcion3.setOnMouseExited(evt->{
            opcion3.setBackground(fondo);
        });

        opcion1.setOnAction(evtm->{
            crearGrafica1();
        });

        opcion2.setOnAction(evt->{
            crearGrafica2();
        });

        opcion3.setOnAction(evt->{
            crearCorteCaja();
        });

        titulo = new Label("Graficas y corte de caja");
        titulo.getStyleClass().add("label-titulo");

        botonHam.setAlignment(Pos.CENTER_LEFT);
        botonHam.setGraphicTextGap(30);
        botonHam.setBackground(fondo);
        botonHam.setStyle(estilo);

        opcion2.setGraphic(icono2);
        opcion2.setAlignment(Pos.CENTER_LEFT);
        opcion2.setGraphicTextGap(30);
        opcion2.setBackground(fondo);
        opcion2.setStyle(estilo);

        opcion3.setGraphic(icono3);
        opcion3.setAlignment(Pos.CENTER_LEFT);
        opcion3.setGraphicTextGap(30);
        opcion3.setBackground(fondo);
        opcion3.setStyle(estilo);
        setAlignment(fondoGrafica, Pos.CENTER);
        setAlignment(titulo, Pos.CENTER);
        setTop(titulo);
        setCenter(fondoGrafica);
        setMinWidth(160);
        setBackground(fondo);
        menuHamburguesa.getItems().addAll(botonHam,new Label(""), opcion1,opcion2,opcion3);
        setLeft(menuHamburguesa);
    }

    private void crearCorteCaja() {
        Label Dinero = new Label("Dinero esperado en caja: $4500");
        Label Caja = new Label("Dinero en caja: $");
        TextField llenar = new TextField();
        Button btn = new Button("Aceptar");
        btn.getStyleClass().add("cssBoton");
        llenar.setPromptText("Dinero en la caja");
        GridPane pan = new GridPane();
        pan.setAlignment(Pos.CENTER);
        pan.setHgap(30);
        pan.setVgap(30);
        pan.add(Dinero,2,2);
        pan.add(Caja,2,3);
        pan.add(llenar,2,4);
        pan.add(btn,2,5);


        setCenter(pan);
    }

    private void crearGrafica2() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Dia");
        yAxis.setLabel("Numero de pasteles vendidos");
        //creating the chart
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis,yAxis);

        lineChart.setTitle("Ventas de pasteles, Semana 3");
        //defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        //populating the series with data
        series.getData().add(new XYChart.Data<String, Number>("Lunes", 5));
        series.getData().add(new XYChart.Data<String, Number>("Martes", 4));
        series.getData().add(new XYChart.Data<String, Number>("Miercoles", 3));
        series.getData().add(new XYChart.Data<String, Number>("Jueves", 4));
        series.getData().add(new XYChart.Data<String, Number>("Viernes", 7));
        series.getData().add(new XYChart.Data<String, Number>("Sabado", 14));
        series.getData().add(new XYChart.Data<String, Number>("Domingo", 15));
        lineChart.getData().add(series);
        setCenter(lineChart);
    }

    private void crearGrafica1() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mes");
        yAxis.setLabel("Numero de pasteles vendidos");
        //creating the chart
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis,yAxis);

        lineChart.setTitle("Ventas de pasteles, 2022");
        //defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        //populating the series with data
        series.getData().add(new XYChart.Data<String, Number>("Enero", 23));
        series.getData().add(new XYChart.Data<String, Number>("Febrero", 14));
        series.getData().add(new XYChart.Data<String, Number>("Marzo", 15));
        series.getData().add(new XYChart.Data<String, Number>("Abril", 24));
        series.getData().add(new XYChart.Data<String, Number>("Mayo", 34));
        series.getData().add(new XYChart.Data<String, Number>("Junio", 36));
        series.getData().add(new XYChart.Data<String, Number>("Julio", 0));
        series.getData().add(new XYChart.Data<String, Number>("Agosto", 0));
        series.getData().add(new XYChart.Data<String, Number>("Septiembre", 0));
        series.getData().add(new XYChart.Data<String, Number>("Octubre", 0));
        series.getData().add(new XYChart.Data<String, Number>("Noviembre", 0));
        series.getData().add(new XYChart.Data<String, Number>("Diciembre", 0));
        lineChart.getData().add(series);
        setCenter(lineChart);
    }
}
