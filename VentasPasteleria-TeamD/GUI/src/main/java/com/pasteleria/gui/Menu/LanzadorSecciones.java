package com.pasteleria.gui.Menu;

import com.pasteleria.gui.Pastel.PantallaPastel;
import com.pasteleria.gui.Pedido.PantallaPedido;
import com.pasteleria.gui.Trabajador.PantallaTrabajador;
import com.pasteleria.gui.Venta.PantallaVenta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LanzadorSecciones extends BorderPane {
    //Esta linea de background sera alterada por los estilos, solo usar como backup
    Background fondoDashboard = new Background(new BackgroundFill(Color.valueOf("F0E3F0"), new CornerRadii(0), new Insets(0)));
    TilePane contenedorIconos = null;
    Font tipoLetraTitulo;
    Font tipoLetraDescripcion;

    Label etiPasteles;
    Label descPasteles;

    Label etiTrabajadores;
    Label descTrabajadores;

    Label etiClientes;
    Label descClientes;

    Label etiDirecciones;
    Label descDirecciones;

    Label etiVentas;
    Label descVentas;

    Label etiPedido;
    Label descPedido;

    VBox contPasteles;
    VBox contTrabajadores;
    VBox contClientes;
    VBox contDirecciones;
    VBox contVentas;
    VBox contPedido;

    ImageView imvPasteles;
    ImageView imvTrabajadores;
    ImageView imvClientes;
    ImageView imvDirecciones;
    ImageView imvVentas;

    Button btnPasteles;
    Button btnTrabajadores;
    Button btnClientes;
    Button btnDirecciones;
    Button btnVentas;
    Button btnPedido;

    //Estos elementos se toman del stage inicial para reemplazarlos despues
    TabPane tabPane;
    Tab tab;
    Stage stage;

    //Constructor original
    public LanzadorSecciones(){
        inicializarComponentes(tabPane, tab);
    }

    //Constructor de Diego
    public LanzadorSecciones(TabPane tabPane, Tab tab, Stage stage){
        this.stage=stage;
        this.tabPane = tabPane;
        this.tab = tab;
        inicializarComponentes(tabPane, tab);
    }

    public void inicializarComponentes(TabPane tabPane, Tab tab){
        //getStylesheets().add(getClass().getResource("gui/styles.css").toExternalForm());
        //Muestra del grid
        contenedorIconos = new TilePane();
        contenedorIconos.setVgap(12);
        contenedorIconos.setHgap(12);
        contenedorIconos.setPadding(new Insets(10));
        contenedorIconos.setPrefColumns(3);

        //Esto debe de ir en el styles mas que nada
        tipoLetraTitulo = Font.font("Poppins", FontWeight.BOLD, 16);
        tipoLetraDescripcion = Font.font("NanumGothic", 12);

        //Imagenes
        imvPasteles = new ImageView("cake.png");
        imvPasteles.setFitWidth(200);
        imvPasteles.setFitHeight(200);

        imvTrabajadores = new ImageView("Users.png");
        imvTrabajadores.setFitWidth(200);
        imvTrabajadores.setFitHeight(200);

        imvClientes = new ImageView("Clientes.png");
        imvClientes.setFitWidth(200);
        imvClientes.setFitHeight(200);

        imvDirecciones = new ImageView("Location.png");
        imvDirecciones.setFitWidth(200);
        imvDirecciones.setFitHeight(200);

        imvVentas = new ImageView("Cash.png");
        imvVentas.setFitWidth(200);
        imvVentas.setFitHeight(200);

        //Etiquetas
        etiPasteles = new Label("Pasteles");
        descPasteles = new Label("Modificar info de pasteles");

        etiTrabajadores=new Label("Trabajadores");
        descTrabajadores=new Label("Administracion de cuentas");

        etiClientes=new Label("Clientes");
        descClientes=new Label ("Ver info de clientes");

        etiDirecciones=new Label("Direcciones");
        descDirecciones=new Label("Directorios de entrega");

        etiVentas=new Label("Venta");
        descVentas=new Label("Crear venta");

        etiPedido=new Label("Pedido");
        descPedido=new Label("Crear Pedido");

        //Botones
        //Cada onAction debe de mandar al nuevo contenedor donde se encuentra el panel.
        btnPasteles = new Button("");
        btnPasteles.setGraphic(imvPasteles);
        btnPasteles.setMaxWidth(200);
        btnPasteles.setMaxWidth(200);
        btnPasteles.getStyleClass().add("btnLanzador");
        btnPasteles.setOnAction(e ->{
            PantallaPastel panelPastel = new PantallaPastel(tabPane, tab);
            tab.setContent(panelPastel);
          tab.setText("Pasteles");
        });

        btnTrabajadores = new Button("");
        btnTrabajadores.setGraphic(imvTrabajadores);
        btnTrabajadores.setMaxWidth(200);
        btnTrabajadores.setMinWidth(200);
        btnTrabajadores.getStyleClass().add("btnLanzador");
        btnTrabajadores.setOnAction(e ->{
            PantallaTrabajador panelTrabajadores = new PantallaTrabajador(tabPane, tab);
            tab.setContent(panelTrabajadores);
            tab.setText("Trabajadores");
        });

        btnClientes = new Button("");
        btnClientes.setGraphic(imvClientes);
        btnClientes.setMaxWidth(200);
        btnClientes.setMinWidth(200);
        btnClientes.getStyleClass().add("btnLanzador");
        btnClientes.setOnAction(e->{

            //FALTA EL PANEL DE CLIENTES. REEMPLAZAR PANTALLAS DE PROVEEDORES Y DESPUES ANCLAR AQUI

            //PantallaCli panelIngred = new PantallaIngrediente(tabPane, tab);
            //tab.setContent(panelIngred);
            //tab.setText("Ingredientes");
        });

        btnDirecciones = new Button("");
        btnDirecciones.setGraphic(imvDirecciones);
        btnDirecciones.setMaxWidth(200);
        btnDirecciones.setMinWidth(200);
        btnDirecciones.getStyleClass().add("btnLanzador");
        btnDirecciones.setOnAction(e->{

            //FALTA UN PANEL ROOT QUE CONTENGA LA TABLA DE LAS DIRECCIONES

        //    Contenedor estadisticas = new ContenedorEstadisticas();
        //    tab.setContent(estadisticas);
        //    tab.setText("Estadisticas");
        });

        btnVentas = new Button("");
        btnVentas.setGraphic(imvVentas);
        btnVentas.setMinWidth(200);
        btnVentas.setMaxWidth(200);
        btnVentas.getStyleClass().add("btnLanzador");
        btnVentas.setOnAction(e->{
            PantallaVenta pantallaVenta = new PantallaVenta(tabPane, tab);
            tab.setContent(pantallaVenta);
            tab.setText("Venta");
        });

        btnPedido = new Button("");
        btnPedido.setMinWidth(200);
        btnPedido.setMaxWidth(200);
        btnPedido.getStyleClass().add("btnLanzador");
        btnPedido.setOnAction(e->{
            PantallaPedido pantallaPedidos = new PantallaPedido(tabPane, tab);
            tab.setContent(pantallaPedidos);
            tab.setText("Venta");
        });

        contPasteles = new VBox();
        contPasteles.setAlignment(Pos.TOP_CENTER);
        contPasteles.getChildren().addAll(btnPasteles, etiPasteles, descPasteles);

        contTrabajadores = new VBox();
        contTrabajadores.setAlignment(Pos.TOP_CENTER);
        contTrabajadores.getChildren().addAll(btnTrabajadores, etiTrabajadores, descTrabajadores);

        contClientes = new VBox();
        contClientes.setAlignment(Pos.TOP_CENTER);
        contClientes.getChildren().addAll(btnClientes, etiClientes, descClientes);

        contDirecciones = new VBox();
        contDirecciones.setAlignment(Pos.TOP_CENTER);
        contDirecciones.getChildren().addAll(btnDirecciones, etiDirecciones, descDirecciones);

        contVentas = new VBox();
        contVentas.setAlignment(Pos.TOP_CENTER);
        contVentas.getChildren().addAll(btnVentas, etiVentas, descVentas);

        contPedido = new VBox();
        contPedido.setAlignment(Pos.TOP_CENTER);
        contPedido.getChildren().addAll(btnPedido, etiPedido, descPedido);

        contenedorIconos.setAlignment(Pos.CENTER);
        contenedorIconos.getChildren().addAll(contPasteles, contTrabajadores, contClientes, contDirecciones, contVentas,
                contPedido);
        setBackground(fondoDashboard);
        setCenter(contenedorIconos);
    }


}
