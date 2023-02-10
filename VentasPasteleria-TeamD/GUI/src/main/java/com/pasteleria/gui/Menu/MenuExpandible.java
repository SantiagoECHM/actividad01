package com.pasteleria.gui.Menu;

import com.pasteleria.gui.Main;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MenuExpandible extends ToolBar {
    //Para acciones del boton principal
    private boolean compactado = false;
    //Constructor
    public MenuExpandible(){
        Background fondoNormal = new Background(new BackgroundFill(Color.valueOf("FBFBE4"), new CornerRadii(0), new Insets(0)));
        Background fondoExpandido = new Background(new BackgroundFill(Color.valueOf("F7F2E0"), new CornerRadii(0), new Insets(0)));
        //URL rimagenExpandir = getClass().getResource("menu.png");
        //URL rimagenExpandido = getClass().getResource("menu-close.png");

        ImageView iconoExpandir = new ImageView("menulateral.png");
        ImageView iconoExpandido = new ImageView("MenuClose.png");
        //ImageView iconoExpandir = new ImageView(new Image(getClass().getResource("lines.png").toExternalForm()));
        iconoExpandir.setFitWidth(22);
        iconoExpandir.setFitHeight(22);
        iconoExpandido.setFitWidth(22);
        iconoExpandido.setFitHeight(22);

        //ImageView iconoOpcionColor = new ImageView("Switch.png");
        ImageView iconoOpcionInfo = new ImageView("Guia.png");
        ImageView iconoOpcionError = new ImageView("ReportError.png");
        ImageView iconoOpcionSalir = new ImageView("Logout.png");

        String estiloBoton = "-fx-text-fill: black;  -fx-font-size: 12pt";


        Button opcionInformacion = new Button("Info");
        opcionInformacion.setGraphic(iconoOpcionInfo);
        opcionInformacion.setAlignment(Pos.CENTER_LEFT);
        opcionInformacion.setGraphicTextGap(20);
        opcionInformacion.setBackground(fondoNormal);
        opcionInformacion.setStyle(estiloBoton);
        opcionInformacion.setTooltip(new Tooltip("Ver manual de usuario"));

        opcionInformacion.setOnMouseEntered(evt-> {
            opcionInformacion.setBackground(fondoExpandido);
        });
        opcionInformacion.setOnMouseExited(evt-> {
            opcionInformacion.setBackground(fondoNormal);
        });

        opcionInformacion.setOnAction(evtm->{
            Alert alertaInformacion = new Alert(Alert.AlertType.INFORMATION);
            alertaInformacion.setTitle("Acerca de");
            alertaInformacion.setHeaderText("Sistema de ventas de pasteleria V1.5");
            alertaInformacion.setContentText("Actualizado al 21/11/20222 \n"+
                    "Este programa fue creado para Metodologias de desarrollo por el equipo D\n"+
                    "El usuario actual acepta usar adecuadamente el producto en el momento que empieza a usarlo\n"+
                    "Responsabilidad de los programadores la estabilidad, del usuario, sus acciones en el sistema");
            alertaInformacion.showAndWait();
        });

        Button opcionError = new Button("Problemas");
        opcionError.setGraphic(iconoOpcionError);
        opcionError.setAlignment(Pos.CENTER_LEFT);
        opcionError.setGraphicTextGap(20);
        opcionError.setBackground(fondoNormal);
        opcionError.setStyle(estiloBoton);
        opcionError.setTooltip(new Tooltip("Informar de problemas"));

        opcionError.setOnMouseEntered(evt-> {
            opcionError.setBackground(fondoExpandido);
        });
        opcionError.setOnMouseExited(evt-> {
            opcionError.setBackground(fondoNormal);
        });

        opcionError.setOnAction(evtm->{
            Alert alertaProblemas = new Alert(Alert.AlertType.INFORMATION);
            alertaProblemas.setTitle("Información");
            alertaProblemas.setHeaderText("Comuníquese a los siguientes correos para aclarar alguna duda. \n" +
                    "zs20018225@estudiantes.uv.mx \n" +
                    "zs20018149@estudiantes.uv.mx \n"+
                    "zs20018172@estudiantes.uv.mx \n"+
                    "zs20018167@estudiantes.uv.mx \n" +
                    "zs20018222@estudiantes.uv.mx \n");
            alertaProblemas.setContentText("Favor de indicar el motivo, alguna evidencia y el factor que lo ocasiona.");
            alertaProblemas.showAndWait();
        });

        Button opcionSalir = new Button("Salir");
        opcionSalir.setGraphic(iconoOpcionSalir);
        opcionSalir.setAlignment(Pos.CENTER_LEFT);
        opcionSalir.setGraphicTextGap(30);
        opcionSalir.setBackground(fondoNormal);
        opcionSalir.setStyle(estiloBoton);
        opcionSalir.setTooltip(new Tooltip("Cerrar este sistema (Sirve para reinicio)"));

        opcionSalir.setOnMouseEntered(evt-> {
            opcionInformacion.setBackground(fondoExpandido);
        });
        opcionSalir.setOnMouseExited(evt-> {
            opcionInformacion.setBackground(fondoNormal);
        });

        opcionSalir.setOnAction(evtm->{
            Alert alertaSalir = new Alert(Alert.AlertType.CONFIRMATION);
            alertaSalir.setTitle("Advertencia");
            alertaSalir.setContentText("¿Esta seguro que quiere salir?");
            ButtonType respuesta = alertaSalir.showAndWait().orElse(ButtonType.OK);
            if (ButtonType.OK.equals(respuesta))
                Platform.exit();
        });

        /*Button opcionColor = new Button("Tema Oscuro");
        opcionColor.setGraphic(iconoOpcionColor);
        opcionColor.setAlignment(Pos.CENTER_LEFT);
        opcionColor.setGraphicTextGap(30);
        opcionColor.setBackground(fondoNormal);
        opcionColor.setStyle(estiloBoton);
        opcionColor.setTooltip(new Tooltip("Cambiar de modo"));

        opcionColor.setOnMouseEntered(evt-> {
            opcionInformacion.setBackground(fondoExpandido);
        });
        opcionColor.setOnMouseExited(evt-> {
            opcionInformacion.setBackground(fondoNormal);
        });

        opcionColor.setOnAction(evtm->{
            if(opcionColor.equals("Tema oscuro")){

            }
        });*/

        //Boton de el menu hamburguesa
        Button botonH = new Button("");
        botonH.setGraphic(iconoExpandir);
        botonH.setBackground(fondoNormal);
        botonH.setStyle(estiloBoton);
        botonH.setOnAction(evt-> {
            if (!compactado) {
                botonH.setGraphic(iconoExpandir);
                setMaxWidth(52);
                botonH.setMaxWidth(22);
                botonH.setMinWidth(22);
                //opcionBloqueo.setMaxWidth(52);
                //opcionBloqueo.setMinWidth(52);
                opcionInformacion.setMaxWidth(52);
                opcionInformacion.setMinWidth(52);
                opcionError.setMaxWidth(52);
                opcionError.setMinWidth(52);
                opcionSalir.setMaxWidth(52);
                opcionSalir.setMinWidth(52);
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 52, Interpolator.EASE_BOTH)));
                tiempo.play();
                setMinWidth(52);

            } else {
                botonH.setGraphic(iconoExpandido);
                botonH.setMaxWidth(22);
                botonH.setMinWidth(22);
                setMaxWidth(52);
                //setMaxWidth(160);
                //
                Duration duracion = Duration.millis(500);
                Timeline tiempo = new Timeline(new KeyFrame(duracion, new KeyValue(this.minWidthProperty(), 160, Interpolator.EASE_BOTH)));
                tiempo.play();
                tiempo.setOnFinished(evt2 -> {
                    setMaxWidth(160);
                    //opcionBloqueo.setMaxWidth(150);
                    //opcionBloqueo.setMinWidth(150);
                    opcionInformacion.setMaxWidth(150);
                    opcionInformacion.setMinWidth(150);
                    opcionError.setMaxWidth(150);
                    opcionError.setMinWidth(150);
                    opcionSalir.setMaxWidth(150);
                    opcionSalir.setMinWidth(150);
                });
            }
            compactado = !compactado;
        });
        setPadding(new Insets(0));

        //opcionBloqueo.setMinWidth(150);
        opcionInformacion.setMinWidth(150);
        opcionError.setMinWidth(150);
        opcionSalir.setMinWidth(150);
        setMinWidth(160);
        setOrientation(Orientation.VERTICAL);
        setBackground(fondoNormal);
        getItems().addAll(botonH, new Label(""),opcionInformacion, opcionError, opcionSalir);
    }
}
