package com.pasteleria.gui.Ingrediente;

/*public class PantallaIngrediente extends BorderPane {
    private Label lTitulo;
    private Button bAgregarIngrediente;
    private HBox barra;
   //private TableView<Ingrediente> tablaIngrediente;
    TabPane tabPane;
    Tab tab;
    //private ObservableList<Pastel> pasteles;

    public PantallaIngrediente(TabPane tabPane, Tab tab) {
        getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        this.tabPane = tabPane;
        this.tab = tab;
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.lTitulo = new Label("Ingredientes");
        this.lTitulo.getStyleClass().add("label-titulo");
        this.lTitulo.setPrefHeight(70.0);
        //Pasteles listaHelper = new Pasteles();
        //listaHelper.crearLista();
       /* List<Ingrediente> listaIngredienteHelper = new ArrayList<>();
        TablaIngrediente tablaIngrediente1 = new TablaIngrediente(listaIngredienteHelper);
        this.tablaIngrediente = tablaIngrediente1.getTablaProductos();*/

        //TableView tablaPasteles1 = this.tablaPasteles.getTablaPasteles();
        //TableView tablaPasteles1 = new TableView();
        //tablaPasteles1.setPrefWidth(1000.0);
        /*tablaPasteles1.setOnMouseClicked((evtm) -> {
            Pastel pastelSeleccionado = (Pastel)tablaPasteles1.getSelectionModel().getSelectedItem();
            if (evtm.getClickCount() == 2) {
                int seleccion = tablaPasteles1.getSelectionModel().getSelectedIndex();
                this.editarPastel(pastelSeleccionado, seleccion);
            }

        });*/

        /*this.bAgregarIngrediente = new Button("Agregar Ingrediente");
        this.bAgregarIngrediente.getStyleClass().add("cssBoton");
        this.bAgregarIngrediente.setOnAction((evtm) -> {
           this.agregarIngrediente();
        });
        this.barra = new HBox();
        this.barra.setSpacing(200.0);
        this.barra.setAlignment(Pos.CENTER);
        this.barra.getChildren().addAll(lTitulo, bAgregarIngrediente);
        this.setTop(barra);
        this.setLeft(tablaIngrediente);
    }

    private void agregarIngrediente() {
        Stage stage = new Stage();
        Pane menu = new PantallaAgregarIngredientes();
        //Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Scene scene = new Scene(menu, 500.0, 400.0);
        //scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Agregar Ingrediente");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setMaximized(false);
        stage.show();
    }
    //private void editarPastel(Trabajador usuario, int seleccion) {
    /*private void editarUsuario() {
        Stage stage = new Stage();
        EditarUsuario = new EditarUsuario(stage, pastel, this.tablaUsuarios);
        Scene scene = new Scene(menu, 700.0, 600.0);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Editar pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearPastel() {
        Stage stage = new Stage();
        AgregarPastel menu = new AgregarPastel(stage, this.tablaPasteles);
        Scene scene = new Scene(menu, 700.0, 600.0);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }*/
//}