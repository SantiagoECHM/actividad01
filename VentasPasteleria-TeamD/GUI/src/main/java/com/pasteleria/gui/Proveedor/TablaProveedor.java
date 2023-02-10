package com.pasteleria.gui.Proveedor;

/*public class TablaProveedor {
    private TableView<Proveedor> tablaProveedor;
        private ObservableList<Proveedor> ingredientes = FXCollections.observableArrayList();
        //private Pastel pastel;

        // Agregar a los usuarios desde la base de datos con ayuda del helper

        public TablaProveedor(List<Proveedor> listaIngrediente) {
            this.ingredientes.addAll(listaIngrediente);
            this.tablaProveedor = new TableView<>();
            this.tablaProveedor.getStyleClass().add("table-cell");
            this.tablaProveedor.setPrefWidth(700.0);
            this.crearTabla();
        }
        //crear la tabla con los atributos del usuario

        public void crearTabla() {
            //this.tablaPasteles.setItems(this.pasteles);
            //Cambiar de  <String, String > a <Trabajador, String> segun sea el caso
            //Corregir las tablas en caso de ser necesario
            TableColumn<Proveedor, String> colId = new TableColumn<Proveedor, String>("ID");
            TableColumn<Proveedor, String> colNombre = new TableColumn<Proveedor, String>("Nombre");
            TableColumn<Proveedor, String> colPrecio= new TableColumn<Proveedor, String>("Contrasenia");
            TableColumn<Proveedor, String> colCantidad = new TableColumn<Proveedor, String>("Correo");
            TableColumn<Proveedor, String> colIdProveedor = new TableColumn<Proveedor, String>("Telefono");
            TableColumn<Proveedor, Void> colEliminar = new TableColumn<Proveedor, Void>("Eliminar");

            colEliminar.setPrefWidth(130.0);
            colNombre.setPrefWidth(120.0);
            colPrecio.setPrefWidth(120.0);
            colCantidad.setPrefWidth(120.0);
            colIdProveedor .setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
            colPrecio.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("password"));
            colCantidad.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("correo"));
            colIdProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefono"));

            //Boton de aliminar
            Callback<TableColumn<Proveedor, Void>, TableCell<Proveedor, Void>> cellFactory1 = new Callback<TableColumn<Proveedor, Void>, TableCell<Proveedor, Void>>() {
                public TableCell<Proveedor, Void> call(TableColumn<Proveedor, Void> param) {
                    TableCell<Proveedor, Void> cell1 = new TableCell<Proveedor, Void>() {
                        final Button boton = new Button("Eliminar");

                        {
                            this.boton.setOnAction((evt) -> {
                                this.getTableView().getItems().remove(this.getIndex());
                            });
                            this.boton.setPrefWidth(80.0);
                            this.boton.setPrefHeight(10.0);
                        }

                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                this.setGraphic((Node)null);
                            } else {
                                this.setGraphic(this.boton);
                            }

                        }
                    };
                    return cell1;
                }
            };
            /*Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>> cellFactory2 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
                public TableCell<Pastel, Void> call(TableColumn<Pastel, Void> param) {
                    TableCell<Pastel, Void> cell2 = new TableCell<Pastel, Void>() {
                        final Rectangle color = new Rectangle();

                        {
                            this.color.setWidth(80.0);
                            this.color.setHeight(10.0);
                        }

                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                this.setGraphic((Node)null);
                            } else {
                                String Scolor = ((Pastel)this.getTableView().getItems().get(this.getIndex())).getColor();
                                this.color.setFill(Color.web(Scolor));
                                this.color.setFill(Color.web(Scolor));
                                this.setGraphic(this.color);
                            }

                        }
                    };
                    return cell2;
                }
            };*/

            //colEliminar.setCellFactory(cellFactory1);

            //this.tablaProveedor.getColumns().addAll(colId, colNombre, colPrecio, colCantidad, colIdProveedor);
            //this.tablaProveedor.getColumns().add(colEliminar);

        //Metodos de la tabla
        /*public void agregarPastel(Pastel pastel, int seleccion) {
            this.pasteles.remove(seleccion);
            this.pasteles.add(seleccion, pastel);
        }

        public void agregarPastel(Pastel pastel) {
            this.pasteles.add(pastel);
        }

        public void agregarPasteles(List<Pastel> listaPasteles) {
            for(int i = 0; i < listaPasteles.size(); ++i) {
                this.pasteles.add((Pastel)listaPasteles.get(i));
            }

        }*/

       /* public TableView<Proveedor> getTablaProveedor() {
            return this.tablaProveedor;
        }
/*
        public int total() {
            int total = 0;

            for(int i = 0; i < this.pasteles.size(); ++i) {
                total = (int)((double)total + ((Pastel)this.pasteles.get(i)).getPrecio());
            }

            return total;
        }*/

