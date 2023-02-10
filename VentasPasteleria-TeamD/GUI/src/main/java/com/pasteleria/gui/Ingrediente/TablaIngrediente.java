package com.pasteleria.gui.Ingrediente;

/*public class TablaIngrediente {
    private TableView<Ingrediente> tablaIngredientes;
        private ObservableList<Ingrediente> ingredientes = FXCollections.observableArrayList();
        //private Pastel pastel;

        // Agregar a los usuarios desde la base de datos con ayuda del helper

        public TablaIngrediente(List<Ingrediente> listaIngrediente) {
            this.ingredientes.addAll(listaIngrediente);
            this.tablaIngredientes = new TableView<>();
            this.tablaIngredientes.getStyleClass().add("table-cell");
            this.tablaIngredientes.setPrefWidth(700.0);
            this.crearTabla();
        }
        //crear la tabla con los atributos del usuario

        public void crearTabla() {
            //this.tablaPasteles.setItems(this.pasteles);
            //Cambiar de  <String, String > a <Trabajador, String> segun sea el caso
            //Corregir las tablas en caso de ser necesario
            TableColumn<Ingrediente, String> colId = new TableColumn<Ingrediente, String>("ID");
            TableColumn<Ingrediente, String> colNombre = new TableColumn<Ingrediente, String>("Nombre");
            TableColumn<Ingrediente, String> colPrecio= new TableColumn<Ingrediente, String>("Contrasenia");
            TableColumn<Ingrediente, String> colCantidad = new TableColumn<Ingrediente, String>("Correo");
            TableColumn<Ingrediente, String> colIdProveedor = new TableColumn<Ingrediente, String>("Telefono");
            TableColumn<Ingrediente, Void> colEliminar = new TableColumn<Ingrediente, Void>("Eliminar");

            colEliminar.setPrefWidth(130.0);
            colNombre.setPrefWidth(120.0);
            colPrecio.setPrefWidth(120.0);
            colCantidad.setPrefWidth(120.0);
            colIdProveedor .setPrefWidth(120.0);

            colId.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nombre"));
            colPrecio.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("password"));
            colCantidad.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("correo"));
            colIdProveedor.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("telefono"));

            //Boton de aliminar
            Callback<TableColumn<Ingrediente, Void>, TableCell<Ingrediente, Void>> cellFactory1 = new Callback<TableColumn<Ingrediente, Void>, TableCell<Ingrediente, Void>>() {
                public TableCell<Ingrediente, Void> call(TableColumn<Ingrediente, Void> param) {
                    TableCell<Ingrediente, Void> cell1 = new TableCell<Ingrediente, Void>() {
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

            /*this.tablaIngredientes.getColumns().addAll(colId, colNombre, colPrecio, colCantidad, colIdProveedor);
            this.tablaIngredientes.getColumns().add(colEliminar);
        }
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

        /*public TableView<Ingrediente> getTablaProductos() {
            return this.tablaIngredientes;
        }
        public int total() {
            int total = 0;

            for(int i = 0; i < this.pasteles.size(); ++i) {
                total = (int)((double)total + ((Pastel)this.pasteles.get(i)).getPrecio());
            }

            return total;
        }*/
    //}
